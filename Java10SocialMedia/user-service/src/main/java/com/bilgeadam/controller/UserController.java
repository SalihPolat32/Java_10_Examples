package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.dto.request.UserSaveRequestDto;
import com.bilgeadam.service.UserService;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.bilgeadam.constant.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenManager jwtTokenManager;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto) {

        return ResponseEntity.ok(userService.createNewUser(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestParam String token) {

        return ResponseEntity.ok(userService.activateStatus(token));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<String> updateUserProfile(@Valid @RequestBody UserProfileUpdateRequestDto dto) {

        return ResponseEntity.ok(userService.updateUserProfile(dto));
    }
}