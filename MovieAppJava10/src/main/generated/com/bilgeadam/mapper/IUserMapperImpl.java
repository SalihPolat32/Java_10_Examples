package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.UserResponseDto;
import com.bilgeadam.repository.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-04T11:44:36+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserResponseDto toUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.id( user.getId() );
        userResponseDto.name( user.getName() );
        userResponseDto.surname( user.getSurname() );
        userResponseDto.email( user.getEmail() );
        userResponseDto.phone( user.getPhone() );
        userResponseDto.userType( user.getUserType() );

        return userResponseDto.build();
    }

    @Override
    public User toUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.surname( dto.getSurname() );
        user.password( dto.getPassword() );
        user.email( dto.getEmail() );
        user.phone( dto.getPhone() );

        return user.build();
    }

    @Override
    public List<UserResponseDto> toUserResponseDtoList(List<User> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( dtoList.size() );
        for ( User user : dtoList ) {
            list.add( toUserResponseDto( user ) );
        }

        return list;
    }
}
