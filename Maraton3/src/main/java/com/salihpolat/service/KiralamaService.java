package com.salihpolat.service;

import com.salihpolat.model.Arac;
import com.salihpolat.model.Kiralama;
import com.salihpolat.repository.KiralamaRepository;

import java.util.List;

public class KiralamaService {

    private KiralamaRepository kiralamaRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
    }

    public void kiradakiAraclar() {
        kiralamaRepository.kiradakiAraclar();
    }

    public Kiralama kiralamaEkle(Kiralama kiralama) {
        return kiralamaRepository.kiralamaEkle(kiralama);
    }

    public List<Arac> kisiIdsineGorekiralananAraclar(Long id) {
        return kiralamaRepository.kisiIdsineGorekiralananAraclar(id);
    }
}