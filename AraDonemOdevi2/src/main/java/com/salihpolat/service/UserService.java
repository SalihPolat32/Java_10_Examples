package com.salihpolat.service;

import com.salihpolat.dto.request.UserRequestDto;
import com.salihpolat.dto.response.UserDto;
import com.salihpolat.exception.BadRequestException;
import com.salihpolat.exception.InternalServerErrorException;
import com.salihpolat.exception.ResourceNotFoundException;
import com.salihpolat.mapper.IUserMapper;
import com.salihpolat.model.User;
import com.salihpolat.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public List<UserDto> findAll() {

        try {

            return IUserMapper.INSTANCE.userListToUserDtoList(userRepository.findAll());

        } catch (DataAccessException e) {

            throw new InternalServerErrorException("An Error Occurred While Fetching Categories");

        }
    }

    public UserDto findById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid User ID: " + id);
        }

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User Not Found With ID: " + id);
        }

        UserDto userDto = IUserMapper.INSTANCE.userToUserDto(userRepository.findById(id).get());

        return userDto;
    }

    public User getById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid User ID: " + id);
        }

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }

        return userOptional.get();
    }

    public UserDto save(UserRequestDto userRequestDto) {

        try {

            if (userRequestDto == null) {
                throw new BadRequestException("User Cannot Be null");
            }

            User savedUser = userRepository.save(IUserMapper.INSTANCE.userRequestDtoToUser(userRequestDto));

            UserDto savedUserToUserDto = IUserMapper.INSTANCE.userToUserDto(savedUser);

            return savedUserToUserDto;

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Saving User");

        }
    }

    public UserDto update(UserRequestDto userRequestDto, Long id) {

        userRequestDto.setId(id);

        User user = IUserMapper.INSTANCE.userRequestDtoToUser(userRequestDto);

        User updatedUser = userRepository.save(user);

        return IUserMapper.INSTANCE.userToUserDto(updatedUser);
    }

    public void deleteById(Long id) {

        Optional<User> user = userRepository.findById(id);

        try {

            if (user.isEmpty()) {
                throw new ResourceNotFoundException("User Not Found With ID: " + id);
            }

            userRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An Error Occurred While Deleting User");

        }
    }
}