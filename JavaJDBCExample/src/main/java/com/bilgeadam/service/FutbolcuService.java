package com.bilgeadam.service;

import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.ICrud;
import com.bilgeadam.repository.entity.Futbolcu;

import java.util.List;
import java.util.Optional;

public class FutbolcuService implements ICrud<Futbolcu> {

    private final FutbolcuRepository futbolcuRepository;

    public FutbolcuService(ConnectionProvider connectionProvider) {

        this.futbolcuRepository = new FutbolcuRepository(connectionProvider);
    }

    @Override
    public void save(Futbolcu futbolcu) {

        futbolcuRepository.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {

        futbolcuRepository.update(futbolcu);
    }

    @Override
    public void deleteById(Long id) {

        futbolcuRepository.deleteById(id);
    }

    @Override
    public List<Futbolcu> findAll() {

        return futbolcuRepository.findAll();
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {

        return futbolcuRepository.findById(id);
    }

    public void save2(Futbolcu futbolcu) {

        futbolcuRepository.save2(futbolcu);
    }
}