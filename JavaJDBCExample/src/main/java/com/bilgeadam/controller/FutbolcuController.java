package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.service.FutbolcuService;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;

import java.util.List;
import java.util.Optional;

public class FutbolcuController implements ICrud<Futbolcu> {

    private final FutbolcuService futbolcuService;

    public FutbolcuController(ConnectionProvider connectionProvider) {

        this.futbolcuService = new FutbolcuService(connectionProvider);
    }

    @Override
    public void save(Futbolcu futbolcu) {

        futbolcuService.save(futbolcu);
    }

    public void save2(Futbolcu futbolcu) {

        futbolcuService.save2(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {

        futbolcuService.update(futbolcu);
    }

    @Override
    public void deleteById(Long id) {

        futbolcuService.deleteById(id);
    }

    @Override
    public List<Futbolcu> findAll() {

        return futbolcuService.findAll();
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {

        return futbolcuService.findById(id);
    }
}