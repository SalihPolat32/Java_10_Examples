package com.bilgeadam.service;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.UserResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User register(RegisterRequestDto dto) {
/*
        User user = User.builder().phone(dto.getPhone()).name(dto.getName()).surname(dto.getSurname())
                .email(dto.getEmail()).password(dto.getPassword())
                .build();
*/
        User user = IUserMapper.INSTANCE.toUser(dto);

        return userRepository.save(user);
    }

    public User findById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("UKullanıcı Bulunamadı.");
        }

        return user.get();
    }

    public UserResponseDto login(RegisterRequestDto dto) {

        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

        if (user.isEmpty()) {
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }
/*
        return UserResponseDto.builder()
                .id(user.get().getId())
                .userType(user.get().getUserType())
                .email(user.get().getEmail())
                .name(user.get().getName())
                .surname(user.get().getSurname())
                .phone(user.get().getPhone())
                .build();
 */
        // UserResponseDto userresponseDto = IUserMapper.INSTANCE.toUserResponseDto(user.get());
        // return userresponseDto;

        return IUserMapper.INSTANCE.toUserResponseDto(user.get());
    }

    public List<User> findAllByOrderByName() {

        return userRepository.findAllByOrderByName();
    }

    public List<UserResponseDto> findAllByNameContainingIgnoreCase(String value) {
        List<User> userList = userRepository.findAllByNameContainingIgnoreCase(value);

        if (userList.isEmpty()) {
            throw new RuntimeException("Herhangi Bir Kullanıcı Bulunamadı.");
        }

        // Uzun Yöntem -- Tek Tek Map'leme
        // List<UserResponseDto> list = userList.stream().map(x -> IUserMapper.INSTANCE.toUserResponseDto(x)).collect(Collectors.toList());

        return IUserMapper.INSTANCE.toUserResponseDtoList(userList);
    }
}