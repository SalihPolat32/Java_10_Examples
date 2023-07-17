package com.bilgeadam.main;

import com.bilgeadam.controller.FutbolcuController;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.TakimRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.repository.entity.Takim;
import com.bilgeadam.utility.ConnectionProvider;
/*
 * futbolAppDb
 * -- Futbolcu
 * -- Takım
 */
public class Main {
    public static void main(String[] args) {

        Takim takim = Takim.builder().ad("Beşiktaş").build();

        ConnectionProvider connectionProvider = new ConnectionProvider();

        TakimRepository takimRepository = new TakimRepository(connectionProvider);
//        FutbolcuRepository futbolcuRepository = new FutbolcuRepository(connectionProvider);

        FutbolcuController futbolcuController = new FutbolcuController(connectionProvider);

//        takimRepository.save(takim);
//        System.out.println(takim);

        Futbolcu futbolcu = Futbolcu.builder().ad("Mustafa").mevki("Defans").formaNo(3).takim_id(takim.getId()).build();

        Futbolcu futbolcu2 = Futbolcu.builder().id(7L).ad("MERT").mevki("Forvet").formaNo(8).takim_id(3L).deger(100000000000L).build();

        Futbolcu futbolcu3 = Futbolcu.builder().id(7L).ad("Salih").mevki("Orta Saha").formaNo(12).takim_id(3L).deger(200000000000L).build();

//        futbolcuController.save(futbolcu);

//        futbolcuController.save2(futbolcu2);

//        futbolcuController.save(futbolcu3);

//        futbolcuController.update(futbolcu2);

//        futbolcuController.findAll().forEach(System.out::println);

        System.out.println(futbolcuController.findById(8L));
    }
}