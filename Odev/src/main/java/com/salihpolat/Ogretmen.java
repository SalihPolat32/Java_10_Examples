package com.salihpolat;

import java.util.ArrayList;
import java.util.List;

public class Ogretmen extends OkulPersoneli implements IKisi {

    private EDers ders;
    private List<EDers> dersListesi;

    public Ogretmen(String id, String ad, double maas, EDers ders) {
        super(id, ad, maas);
        this.dersListesi = new ArrayList<>();
        this.ders = ders;
        this.dersListesi.add(ders);
        setGorev("Öğretmen");
    }

    public EDers getDers() {
        return ders;
    }

    public void setDers(EDers ders) {
        this.ders = ders;
    }

    public List<EDers> getDersListesi() {
        return dersListesi;
    }

    public void setDersListesi(List<EDers> dersListesi) {
        this.dersListesi = dersListesi;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "dersListesi=" + dersListesi +
                "} " + super.toString();
    }

    @Override
    public void raporAl() {
        System.out.println("Öğretmen Rapor Aldı.");
    }
}