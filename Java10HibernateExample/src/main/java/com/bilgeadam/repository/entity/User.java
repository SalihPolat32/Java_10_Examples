package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(nullable = false, length = 20)
    @Embedded
    private Name name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    @Size(min = 4, max = 32, message = "Sifre 4 İle 32 Karakter Arasında Olmalıdır.")
    private String password;
    @Transient // Bu Özellik Artık Database'de Gözükmeyecek
    private int age;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EGender gender = EGender.WOMAN;
    /*
     * Her kullanıcının ilgi alanları olsun ve String olarak tutalım
     * ve her bir ilgi alanı türü String olsun
     * Müzik, Sinema
     */
    @ElementCollection
    @Builder.Default
    private List<String> interests = new ArrayList<>();
    /*
     * Bir kullanıcının birden fazla adresi olabilir
     * ve adresleri burada adres türlerine göre tutalım
     * Home: address1
     * Work: address2
     * Other: address3
     */
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<EAddressType, Address> addresses;
}