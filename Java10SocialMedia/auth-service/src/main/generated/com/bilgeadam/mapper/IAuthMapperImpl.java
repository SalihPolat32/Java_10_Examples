package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T14:05:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth toAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder<?, ?> auth = Auth.builder();

        auth.username( dto.getUsername() );
        auth.password( dto.getPassword() );
        auth.email( dto.getEmail() );

        return auth.build();
    }

    @Override
    public RegisterResponseDto toRegisterResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.activationCode( auth.getActivationCode() );
        registerResponseDto.username( auth.getUsername() );

        return registerResponseDto.build();
    }
}
