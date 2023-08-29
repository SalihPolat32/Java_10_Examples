package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.dto.request.UserSaveRequestDto;
import com.bilgeadam.rabbitmq.model.RegisterModel;
import com.bilgeadam.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-29T12:58:53+0300",
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
}
