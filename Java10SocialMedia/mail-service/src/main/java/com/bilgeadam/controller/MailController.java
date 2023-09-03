package com.bilgeadam.controller;

import com.bilgeadam.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constant.EndPoints.MAIL;

@RestController
@RequestMapping(MAIL)
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
}