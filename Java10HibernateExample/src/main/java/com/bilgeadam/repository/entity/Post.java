package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob // Big Data Verileri İçin Kullanılır
    private String content;
    @Builder.Default // Default Hepsine Ekler
    private LocalDateTime date = LocalDateTime.now();
    private Long userId;
}