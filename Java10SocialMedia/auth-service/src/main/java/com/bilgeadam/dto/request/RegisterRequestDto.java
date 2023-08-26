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

    @NotBlank(message = "Username Boş Geçilemez!")
    private String username;

    @NotBlank(message = "Email Boş Geçilemez!")
    @Email
    private String email;

    @NotBlank(message = "Şifre Boş Geçilemez!")
    @Size(min = 5, max = 32, message = "Şifre Uzunluğu En Az 5 Karakter En Fazla 32 Karakter Olabilir!")
    // @Pattern(regexp = "^.*(?=.{5,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;
}