package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "Username Boş Bırakılamaz!!!")
    private String username;

    @NotBlank(message = "Email Boş Bırakılamaz!!!")
    @Email
    private String email;

    @NotBlank(message = "Password Boş Bırakılamaz!!!")
    @Size(min = 5, max = 32, message = "Password 5 ile 32 Karakter Arasında Olmalıdır!!!")
    // @Pattern(regexp = "^.*(?=.{5,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;
}