package com.salihpolat;

public class Memur extends OkulPersoneli implements IKisi {

    public Memur(String id, String ad, double maas) {
        super(id, ad, maas);
        setGorev("Memur");
    }

    @Override
    public void raporAl() {
        System.out.println("Memur Rapor Aldı.");
    }
}