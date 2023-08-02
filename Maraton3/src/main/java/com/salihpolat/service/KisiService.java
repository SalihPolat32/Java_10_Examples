package com.salihpolat.service;

import com.salihpolat.model.Kisi;
import com.salihpolat.repository.KisiRepository;

public class KisiService {

    private KisiRepository kisiRepository;

    public KisiService() {
        this.kisiRepository = new KisiRepository();
    }

    public Kisi kisiEkle(Kisi kisi) {
        return kisiRepository.kisiEkle(kisi);
    }

    public Kisi idyeGoreKisiGetir(Long id) {
        return kisiRepository.idyeGoreKisiGetir(id);
    }
}