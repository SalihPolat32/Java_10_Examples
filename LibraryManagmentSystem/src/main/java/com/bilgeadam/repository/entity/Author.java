package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // Kitapları
    @OneToMany (mappedBy = "author", fetch = FetchType.LAZY)
    // Ara Tablo Özelliklerini Vermek İçin Kullanıyoruz
//    @JoinTable(name = "yazar_kitap",
//            joinColumns = @JoinColumn(name = "kitap_id"),
//            inverseJoinColumns = @JoinColumn(name = "yazar_id"))
    List<Book> books;
}