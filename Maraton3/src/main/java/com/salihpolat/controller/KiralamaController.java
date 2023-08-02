package com.salihpolat.controller;

import com.salihpolat.model.Arac;
import com.salihpolat.model.Kiralama;
import com.salihpolat.service.KiralamaService;

import java.util.List;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }

    public Kiralama kiralamaEkle(Kiralama kiralama) {
        return kiralamaService.kiralamaEkle(kiralama);
    }

    public List<Arac> kisiIdsineGorekiralananAraclar(Long id) {
        return kiralamaService.kisiIdsineGorekiralananAraclar(id);
    }
}