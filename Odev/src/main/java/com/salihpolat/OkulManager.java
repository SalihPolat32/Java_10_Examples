package com.salihpolat;

import java.util.List;

public class OkulManager<T> {

    List<T> liste;

    public void kayitEt(T t) {

        liste.add(t);
    }

    public void kayitSil(T t) {

        liste.remove(t);
    }

    public void verileriGetir(T t) {

        System.out.println(liste);
    }
}