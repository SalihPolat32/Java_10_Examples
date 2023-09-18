package com.bilgeadam.controller;

import com.bilgeadam.service.CommentService;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPoints.COMMENT;

@RestController
@RequestMapping(COMMENT)
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private final JwtTokenManager jwtTokenManager;
}