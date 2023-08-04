package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.UserResponseDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constant.RestApiUrl.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    /*
     * create user metodunu dışarıdan name, surname, email, password, phone
     * parametrelerini alsın daha sonra bunlarla bir user oluşturup database'e
     * kayıt yapalım. Bu işlem için bir endpoint ve service sınıfında gerekli metotları oluşturalım.
     */

    //   @Autowired
    private final UserService userService;

    // http://localhost:8090/user/save?name=Mustafa&surname=%C3%96zt%C3%BCrk&email=musty@gmail.com&phone=123456&password=123

    @GetMapping("/save")
    public ResponseEntity<?> createUser(String name, String surname, String email, String password, String phone) {

        User user = User.builder().name(name).surname(surname).phone(phone).password(password).email(email).build();

        try {

            userService.createUser(user);

            return ResponseEntity.ok(user);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Kullanıcı Oluşturulamadı");

        }
    }

    @GetMapping(REGISTER)
    public ResponseEntity<User> register(RegisterRequestDto dto) {

        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<User> register2(@RequestBody RegisterRequestDto dto) {

        return ResponseEntity.ok(userService.register(dto));
    }

    @GetMapping(FINDBYID + "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<User> findById2(@RequestParam(required = false, defaultValue = "1") Long id) {

        if (id == null) {
            throw new RuntimeException("id null");
        }

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<UserResponseDto> login(@RequestBody RegisterRequestDto dto) {

        return ResponseEntity.ok(userService.login(dto));
    }

    @GetMapping("/orderByName")
    public ResponseEntity<List<User>> findAllByOrderByName() {

        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/containByName")
    public ResponseEntity<List<UserResponseDto>> findAllByNameContainingIgnoreCase(String value) {

        return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(value));
    }
}