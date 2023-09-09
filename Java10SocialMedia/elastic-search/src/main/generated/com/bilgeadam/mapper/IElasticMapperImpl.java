package com.bilgeadam.mapper;

import com.bilgeadam.dto.response.UserProfileFindAllResponseDto;
import com.bilgeadam.rabbitmq.model.RegisterElasticModel;
import com.bilgeadam.repository.entity.UserProfile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-08T09:44:50+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class IElasticMapperImpl implements IElasticMapper {

    @Override
    public List<UserProfile> toUserProfiles(List<UserProfileFindAllResponseDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<UserProfile> list = new ArrayList<UserProfile>( dtos.size() );
        for ( UserProfileFindAllResponseDto userProfileFindAllResponseDto : dtos ) {
            list.add( userProfileFindAllResponseDtoToUserProfile( userProfileFindAllResponseDto ) );
        }

        return list;
    }

    @Override
    public UserProfile toUserProfile(RegisterElasticModel model) {
        if ( model == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.id( model.getId() );
        userProfile.authId( model.getAuthId() );
        userProfile.username( model.getUsername() );
        userProfile.email( model.getEmail() );

        return userProfile.build();
    }

    protected UserProfile userProfileFindAllResponseDtoToUserProfile(UserProfileFindAllResponseDto userProfileFindAllResponseDto) {
        if ( userProfileFindAllResponseDto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( userProfileFindAllResponseDto.getAuthId() );
        userProfile.username( userProfileFindAllResponseDto.getUsername() );
        userProfile.email( userProfileFindAllResponseDto.getEmail() );
        userProfile.phone( userProfileFindAllResponseDto.getPhone() );
        userProfile.address( userProfileFindAllResponseDto.getAddress() );
        userProfile.avatar( userProfileFindAllResponseDto.getAvatar() );
        userProfile.about( userProfileFindAllResponseDto.getAbout() );
        userProfile.name( userProfileFindAllResponseDto.getName() );
        userProfile.surName( userProfileFindAllResponseDto.getSurName() );
        userProfile.birthDate( userProfileFindAllResponseDto.getBirthDate() );
        userProfile.status( userProfileFindAllResponseDto.getStatus() );

        return userProfile.build();
    }
}
