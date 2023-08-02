package com.salihpolat.controller;

import com.salihpolat.model.Kisi;
import com.salihpolat.service.KisiService;

public class KisiController {

    private KisiService kisiService;

    public KisiController() {
        this.kisiService = new KisiService();
    }

    public Kisi kisiEkle(Kisi kisi) {
        return kisiService.kisiEkle(kisi);
    }

    public Kisi idyeGoreKisiGetir(Long id) {
        return kisiService.idyeGoreKisiGetir(id);
    }
}