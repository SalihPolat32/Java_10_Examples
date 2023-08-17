package com.socialmedia.service;

import com.socialmedia.convertor.Convertor;
import com.socialmedia.dto.request.LoginRequestDto;
import com.socialmedia.dto.request.RegisterRequestDto;
import com.socialmedia.dto.response.RegisterResponseDto;
import com.socialmedia.mapper.IAuthMapper;
import com.socialmedia.repository.IAuthRepository;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.utility.CodeGenerator;
import com.socialmedia.utility.ServiceManager;
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
 */

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    private AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {

        // max 5 paremetre sonrası dto kullanmamız gerekkiyor

        // Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        Auth auth = Convertor.convertFromDtoToAuth(dto);

        auth.setActivationCode(CodeGenerator.generateCode());

        save(auth);

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        return responseDto;
    }

    public boolean login(LoginRequestDto dto) {

        Optional<Auth> optionalAuth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        if (optionalAuth.isEmpty()) {
            throw new RuntimeException("Böyle Biri Veritabanında Yok!'");
        } else {
            return true;
        }
    }
}