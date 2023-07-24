package com.bilgeadam.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @ToString.Include
    private String city;
    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "addresses")
    @Builder.Default
    @ToString.Exclude
    private Set<UserInformation> userInformations = new HashSet<>();
}