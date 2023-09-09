package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.dto.request.UserSaveRequestDto;
import com.bilgeadam.dto.response.UserProfileFindAllResponseDto;
import com.bilgeadam.rabbitmq.model.RegisterElasticModel;
import com.bilgeadam.rabbitmq.model.RegisterModel;
import com.bilgeadam.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-08T09:50:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserProfile toUserProfile(UserSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( dto.getAuthId() );
        userProfile.username( dto.getUsername() );
        userProfile.email( dto.getEmail() );

        return userProfile.build();
    }

    @Override
    public UserProfile toUserProfile(RegisterModel model) {
        if ( model == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( model.getAuthId() );
        userProfile.username( model.getUsername() );
        userProfile.email( model.getEmail() );

        return userProfile.build();
    }

    @Override
    public UserProfile toUserProfile(UserProfileUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.username( dto.getUsername() );
        userProfile.email( dto.getEmail() );
        userProfile.phone( dto.getPhone() );
        userProfile.address( dto.getAddress() );
        userProfile.avatar( dto.getAvatar() );
        userProfile.about( dto.getAbout() );
        userProfile.name( dto.getName() );
        userProfile.surName( dto.getSurName() );

        return userProfile.build();
    }

    @Override
    public UserProfileFindAllResponseDto toUserProfileFindAllResponseDto(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UserProfileFindAllResponseDto.UserProfileFindAllResponseDtoBuilder userProfileFindAllResponseDto = UserProfileFindAllResponseDto.builder();

        userProfileFindAllResponseDto.id( userProfile.getId() );
        userProfileFindAllResponseDto.authId( userProfile.getAuthId() );
        userProfileFindAllResponseDto.username( userProfile.getUsername() );
        userProfileFindAllResponseDto.email( userProfile.getEmail() );
        userProfileFindAllResponseDto.phone( userProfile.getPhone() );
        userProfileFindAllResponseDto.address( userProfile.getAddress() );
        userProfileFindAllResponseDto.avatar( userProfile.getAvatar() );
        userProfileFindAllResponseDto.about( userProfile.getAbout() );
        userProfileFindAllResponseDto.name( userProfile.getName() );
        userProfileFindAllResponseDto.surName( userProfile.getSurName() );
        userProfileFindAllResponseDto.birthDate( userProfile.getBirthDate() );
        userProfileFindAllResponseDto.status( userProfile.getStatus() );

        return userProfileFindAllResponseDto.build();
    }

    @Override
    public RegisterElasticModel toRegisterElasticModel(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        RegisterElasticModel.RegisterElasticModelBuilder registerElasticModel = RegisterElasticModel.builder();

        registerElasticModel.id( userProfile.getId() );
        registerElasticModel.authId( userProfile.getAuthId() );
        registerElasticModel.username( userProfile.getUsername() );
        registerElasticModel.email( userProfile.getEmail() );

        return registerElasticModel.build();
    }
}
