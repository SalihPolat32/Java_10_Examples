package com.salihpolat.mapper;

import com.salihpolat.dto.request.UserRequestDto;
import com.salihpolat.dto.response.UserDto;
import com.salihpolat.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> userList);

    User userRequestDtoToUser(UserRequestDto userRequestDto);
}