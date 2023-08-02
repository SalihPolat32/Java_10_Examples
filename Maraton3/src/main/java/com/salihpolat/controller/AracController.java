package com.salihpolat.controller;

import com.salihpolat.model.Arac;
import com.salihpolat.service.AracService;

import java.util.List;

public class AracController {

    private AracService aracService;

    public AracController() {
        this.aracService = new AracService();
    }

    public Arac aracEkleme(Arac arac) {
        return aracService.aracEkleme(arac);
    }

    public Arac idyeGoreAracBulma(Long id) {
        return aracService.idyeGoreAracBulma(id);
    }

    public List<Arac> kiradakiAracler() {
        return aracService.kiradakiAraclar();
    }

    public List<Arac> musaitAracler() {
        return aracService.musaitAraclar();
    }
}