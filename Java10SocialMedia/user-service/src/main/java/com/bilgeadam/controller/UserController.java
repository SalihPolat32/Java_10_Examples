package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserProfileUpdateRequestDto;
import com.bilgeadam.dto.request.UserSaveRequestDto;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.repository.enums.EStatus;
import com.bilgeadam.service.UserService;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constant.EndPoints.*;

/*
 * findByStatus Metodu Yazıp cache'leme Yapalım
 */

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

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<UserProfile>> findAll() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find_by_username/{username}")
    public ResponseEntity<UserProfile> findByUsername(@PathVariable String username) {

        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/find_by_status/{status}")
    public ResponseEntity<List<UserProfile>> findByStatus(@PathVariable EStatus status) {

        return ResponseEntity.ok(userService.findByStatus(status));
    }

    @GetMapping("/find_by_status2/{status}")
    public ResponseEntity<List<UserProfile>> findByStatus(@PathVariable String status) {

        return ResponseEntity.ok(userService.findByStatus(status));
    }

    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@RequestParam Long id) {

        return ResponseEntity.ok(userService.deleteUserProfile(id));
    }
}