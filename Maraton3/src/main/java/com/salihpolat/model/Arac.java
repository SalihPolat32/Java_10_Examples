package com.salihpolat.model;

import com.salihpolat.model.enums.EAracDurum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

    @Column(name = "uretim_yili")
    private String uretimYili;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EAracDurum durum = EAracDurum.MUSAIT;
}