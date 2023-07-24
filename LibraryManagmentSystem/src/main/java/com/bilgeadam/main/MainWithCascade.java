package com.bilgeadam.main;

import com.bilgeadam.repository.UsersRepository;

public class MainWithCascade {

    public static void main(String[] args) {

        UsersRepository userRepository = new UsersRepository();

//        Users user = Users.builder().username("musty").password("123456")
//                .userInformation(UserInformation.builder().firstName("Mustafa").lastName("ÖZTÜRK")
//                        .address(Address.builder().city("Ankara").country("Türkiye").build()).build()).build();
//
//        userRepository.save(user);
    }
}