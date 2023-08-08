package com.salihpolat.controller;

import com.salihpolat.dto.response.UserDto;
import com.salihpolat.model.User;
import com.salihpolat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salihpolat.constant.RestApiUrl.USER;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(USER)
    public ResponseEntity<UserDto> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping(USER)
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(USER + "/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(USER + "/{userId}")
    public ResponseEntity<UserDto> update(@RequestBody User user, @PathVariable(name = "userId") Long id) {
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping(USER + "/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "userId") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}