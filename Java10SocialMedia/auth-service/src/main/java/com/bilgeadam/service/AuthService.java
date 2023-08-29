package com.bilgeadam.service;

import com.bilgeadam.dto.request.ActivateRequestDto;
import com.bilgeadam.dto.request.AuthUpdateRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.exception.AuthManagerException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.IUserManager;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.rabbitmq.producer.ActivationProducer;
import com.bilgeadam.rabbitmq.producer.RegisterProducer;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.enums.EStatus;
import com.bilgeadam.utility.CodeGenerator;
import com.bilgeadam.utility.JwtTokenManager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
 * 1) Register işlemi yapacağız
 * dto alsın dto dönsün
 * request dto --> username, password, email
 * response dto --> username, id, activation code
 * repodan controller'e kadar yazalım
 *
 * GetMapping --> veriler nereden geliyor url
 * PostMapping --> Body
 *
 * 2) Login metodu yazalım
 * dto alsın eğer veritabanında kayıt varsa true dönsün yoksa false dönsün
 *
 * 3) Active status --> Boolean Dönsün
 */

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    private final JwtTokenManager jwtTokenManager;

    private final IUserManager userManager;

    private final RegisterProducer registerProducer;

    private final ActivationProducer activationProducer;

    public AuthService(IAuthRepository authRepository, JwtTokenManager jwtTokenManager, IUserManager userManager, RegisterProducer registerProducer, ActivationProducer activationProducer) {

        super(authRepository);

        this.authRepository = authRepository;

        this.jwtTokenManager = jwtTokenManager;

        this.userManager = userManager;

        this.registerProducer = registerProducer;

        this.activationProducer = activationProducer;
    }

    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        auth.setActivationCode(CodeGenerator.generateCode());

        if (authRepository.existsByUsername(dto.getUsername())) {
            throw new AuthManagerException(ErrorType.USERNAME_ALREADY_EXIST);
        }

        save(auth);

        // Bir metot yazacağız 2 microservis arası haberleşme için

        userManager.save(IAuthMapper.INSTANCE.toUserSaveRequestDto(auth));

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        String token = jwtTokenManager.createToken(auth.getId())
                .orElseThrow(() -> new AuthManagerException(ErrorType.INVALID_TOKEN));

        responseDto.setToken(token);

        return responseDto;
    }

    @Transactional
    public RegisterResponseDto registerWithRabbitMq(RegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        auth.setActivationCode(CodeGenerator.generateCode());

        if (authRepository.existsByUsername(dto.getUsername())) {
            throw new AuthManagerException(ErrorType.USERNAME_ALREADY_EXIST);
        }

        save(auth);

        // rabbit mq İle Haberleştireceğiz

        registerProducer.sendNewUser(IAuthMapper.INSTANCE.toRegisterModel(auth));

        // register token Oluşturma

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        String token = jwtTokenManager.createToken(auth.getId())
                .orElseThrow(() -> new AuthManagerException(ErrorType.INVALID_TOKEN));

        responseDto.setToken(token);

        return responseDto;
    }

    public String login(LoginRequestDto dto) {

        Optional<Auth> optionalAuth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }

        if (!optionalAuth.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }

        return jwtTokenManager.createToken(optionalAuth.get().getId(), optionalAuth.get().getRole())
                .orElseThrow(() -> new AuthManagerException(ErrorType.TOKEN_NOT_CREATED));
    }

    @Transactional
    public String activateStatus(ActivateRequestDto dto) {

        Optional<Long> id = jwtTokenManager.getIdFromToken(dto.getToken());

        if (id.isEmpty()) {
            throw new AuthManagerException(ErrorType.INVALID_TOKEN);
        }

        Optional<Auth> optionalAuth = findById(id.get());

        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }

        if (optionalAuth.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ALREADY_ACTIVE);
        }

        if (dto.getActivationCode().equals(optionalAuth.get().getActivationCode())) {
            optionalAuth.get().setStatus(EStatus.ACTIVE);
            update(optionalAuth.get());
            // userManager.activateStatus(dto.getToken());     // open feign İle Haberleşme
            activationProducer.activateStatus(dto.getToken()); // rabbitmq İle Haberleşme
            return "Hesabınız Aktive Edilmiştir.";
        } else {
            throw new AuthManagerException(ErrorType.INVALID_CODE);
        }
    }

    public String updateAuth(AuthUpdateRequestDto dto) {

        Optional<Auth> auth = findById(dto.getId());

        if (auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }

        auth.get().setEmail(dto.getEmail());

        auth.get().setUsername(dto.getUsername());

        update(auth.get());

        return "Guncelleme Başarılı.";
    }
}