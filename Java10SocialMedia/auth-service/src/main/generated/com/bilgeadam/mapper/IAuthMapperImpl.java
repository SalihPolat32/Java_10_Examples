package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.request.UserSaveRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.rabbitmq.model.MailModel;
import com.bilgeadam.rabbitmq.model.RegisterModel;
import com.bilgeadam.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-31T13:29:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
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

    @Override
    public UserSaveRequestDto toUserSaveRequestDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        UserSaveRequestDto.UserSaveRequestDtoBuilder userSaveRequestDto = UserSaveRequestDto.builder();

        userSaveRequestDto.authId( auth.getId() );
        userSaveRequestDto.username( auth.getUsername() );
        userSaveRequestDto.email( auth.getEmail() );

        return userSaveRequestDto.build();
    }

    @Override
    public RegisterModel toRegisterModel(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterModel.RegisterModelBuilder registerModel = RegisterModel.builder();

        registerModel.authId( auth.getId() );
        registerModel.username( auth.getUsername() );
        registerModel.email( auth.getEmail() );

        return registerModel.build();
    }

    @Override
    public MailModel toMailModel(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        MailModel.MailModelBuilder mailModel = MailModel.builder();

        mailModel.activationCode( auth.getActivationCode() );
        mailModel.email( auth.getEmail() );
        mailModel.username( auth.getUsername() );

        return mailModel.build();
    }
}
