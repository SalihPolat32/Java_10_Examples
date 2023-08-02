package com.salihpolat.soru1;

import java.time.LocalDate;

public class GenelMudur extends Personel {

    private static int idSayar = 1;
    private int id;

    public GenelMudur(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(2));
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        GenelMudur.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "id=" + id +
                "} " + super.toString();
    }
}