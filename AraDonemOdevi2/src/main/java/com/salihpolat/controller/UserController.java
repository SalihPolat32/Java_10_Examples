package com.salihpolat.controller;

import com.salihpolat.dto.request.UserRequestDto;
import com.salihpolat.dto.response.UserDto;
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

    @GetMapping(USER)
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(USER + "/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping(USER)
    public ResponseEntity<UserDto> save(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequestDto));
    }

    @PutMapping(USER + "/{userId}")
    public ResponseEntity<UserDto> update(@RequestBody UserRequestDto userRequestDto, @PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(userService.update(userRequestDto, id));
    }

    @DeleteMapping(USER + "/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "userId") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}