package com.bilgeadam.controller;

import com.bilgeadam.service.UserService;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPoints.USER;

/*
 * findbystatus Metodu Yazıp cacheleme Yapalım
 */
@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenManager jwtTokenManager;
}