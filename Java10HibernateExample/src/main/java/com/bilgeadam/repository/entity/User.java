package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    @Size(min = 4, max = 32, message = "Şifre 4 İle 32 Karakter Arasında Olmalıdır.")
    private String password;
    private int age;
    private EGender gender;
}