package com.salihpolat.service;

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

            throw new InternalServerErrorException("An error occurred while fetching categories");

        }
    }

    public UserDto findById(Long id) {
        if (id <= 0) {
            throw new BadRequestException("Invalid user ID: " + id);
        }

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        UserDto userDto = IUserMapper.INSTANCE.userToUserDto(userRepository.findById(id).get());

        return userDto;
    }

    public UserDto save(User user) {

        try {

            if (user == null) {
                throw new BadRequestException("User cannot be null");
            }

            UserDto userDto = IUserMapper.INSTANCE.userToUserDto(userRepository.save(user));

            return userDto;

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while saving user");

        }
    }

    public void deleteById(Long id) {

        Optional<User> user = userRepository.findById(id);

        try {

            if (user.isEmpty()) {
                throw new ResourceNotFoundException("User not found with ID: " + id);
            }

            userRepository.deleteById(id);

        } catch (Exception e) {

            throw new InternalServerErrorException("An error occurred while deleting user");

        }
    }
}