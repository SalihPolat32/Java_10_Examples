package com.bilgeadam.main;

import com.bilgeadam.controller.PostController;
import com.bilgeadam.controller.UserController;
import com.bilgeadam.repository.entity.*;
import com.bilgeadam.repository.enums.EGender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws InterruptedException {

        UserController userController = new UserController();

        List<String> interest1 = List.of("Müzik", "Dans");
        List<String> interest2 = List.of("Sinema", "Tiyatro");

        // 1. Map
        Map<EAddressType, Address> map1 = new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("Ankara").country("Turkey").build());
        map1.put(EAddressType.WORK, Address.builder().city("İstanbul").country("Turkey").build());

        // 2. Map
        Map<EAddressType, Address> map2 = new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("İzmir").country("Turkey").build());
        map1.put(EAddressType.WORK, new Address("Antalya", "Turkey"));

        User user = User.builder()
                .name(Name.builder().firstName("Ece").middleName("Beren").lastName("ERENOĞLU").build())
                .username("ecebe")
                .password("456789")
                // .gender(EGender.WOMAN)
                .interests(interest1)
                .addresses(map1)
                .age(18)
                .build();

        User user2 = User.builder()
                .name(Name.builder().firstName("Mustafa").lastName("ÖZTÜRK").build())
                .username("musty")
                .password("12345")
                .gender(EGender.MAN)
                .interests(interest2)
                .addresses(map2)
                .age(35)
                .build();

        System.out.println(userController.save(user));
        System.out.println(userController.save(user2));

        PostController postController = new PostController();

        Post post1 = Post.builder().content("İlk Post").userId(user.getId()).build();

        postController.save(post1);

        Thread.sleep(2000);

        userController.findAll().forEach(x -> System.out.println(x.getUsername()));
    }
}