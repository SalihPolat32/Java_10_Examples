package com.salihpolat.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isim_soyisim")
    private String isimSoyisim;

    @ToString.Exclude
    @OneToMany(mappedBy = "kisi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Kiralama> kiralamaList;
}