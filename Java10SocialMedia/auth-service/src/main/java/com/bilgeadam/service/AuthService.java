package com.bilgeadam.service;

import com.bilgeadam.dto.request.ActivateRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.exception.AuthManagerException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.enums.EStatus;
import com.bilgeadam.utility.CodeGenerator;
import com.bilgeadam.utility.JwtTokenManager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

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
 * 3) Active status
 */

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    // Depenfency Injec --> constructor injection, setter injection, field injection
    private final IAuthRepository authRepository;

    private final JwtTokenManager jwtTokenManager; // singleton üretilen JwtTokenManager sınıfının bu AuthService'e çağırılıp lullanıma açılma işlemidir.


    public AuthService(IAuthRepository authRepository, JwtTokenManager jwtTokenManager) {

        super(authRepository);

        this.authRepository = authRepository;

        this.jwtTokenManager = jwtTokenManager;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        auth.setActivationCode(CodeGenerator.generateCode());

        if (authRepository.existsByUsername(dto.getUsername())) {
            throw new AuthManagerException(ErrorType.USERNAME_ALREADY_EXISTS);
        }

        save(auth);

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

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

        // Farklı bir Optional kontrolü
        return jwtTokenManager.createToken(optionalAuth.get().getId()).orElseThrow(() -> {
            throw new AuthManagerException(ErrorType.INVALID_TOKEN);
        });
    }

    public String activateStatus(ActivateRequestDto dto) {

        Optional<Long> authId = jwtTokenManager.getIdFromToken(dto.getToken());

        if (authId.isEmpty()) {
            throw new AuthManagerException(ErrorType.INVALID_TOKEN);
        }

        Optional<Auth> optionalAuth = findById(authId.get());

        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }

        if (optionalAuth.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ALREADY_ACTIVE);
        }

        if (dto.getActivationCode().equals(optionalAuth.get().getActivationCode())) {
            optionalAuth.get().setStatus(EStatus.ACTIVE);
            update(optionalAuth.get());
            return "Hesabınız Aktif Edildi!";
        } else {
            throw new AuthManagerException(ErrorType.INVALID_CODE);
        }
    }
}