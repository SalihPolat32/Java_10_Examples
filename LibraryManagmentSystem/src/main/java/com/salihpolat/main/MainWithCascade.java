package com.salihpolat.main;

import com.salihpolat.repository.UsersRepository;
import com.salihpolat.repository.entity.Address;
import com.salihpolat.repository.entity.UserInformation;
import com.salihpolat.repository.entity.Users;

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