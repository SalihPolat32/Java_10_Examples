package com.salihpolat.service;

import com.salihpolat.model.Arac;
import com.salihpolat.repository.AracRepository;

import java.util.List;

public class AracService {

    private AracRepository aracRepository;

    public AracService() {
        this.aracRepository = new AracRepository();
    }

    public Arac aracEkleme(Arac arac) {
        return aracRepository.aracEkleme(arac);
    }

    public Arac idyeGoreAracBulma(Long id) {
        return aracRepository.idyeGoreAracBulma(id);
    }

    public List<Arac> kiradakiAraclar() {
        return aracRepository.kiradakiAraclar();
    }

    public List<Arac> musaitAraclar() {
        return aracRepository.musaitAraclar();
    }
}