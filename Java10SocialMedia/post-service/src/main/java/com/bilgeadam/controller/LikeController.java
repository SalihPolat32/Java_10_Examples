package com.bilgeadam.controller;

import com.bilgeadam.service.LikeService;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPoints.LIKE;

@RestController
@RequestMapping(LIKE)
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    private final JwtTokenManager jwtTokenManager;
}