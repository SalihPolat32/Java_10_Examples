package com.salihpolat.soru1;

import java.time.LocalDate;

public class MuhasebePersoneli extends Personel {

    private static int idSayar = 1;
    private int id;
    private int muhasebeDeneyimSuresi;

    public MuhasebePersoneli(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, int muhasebeDeneyimSuresi) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.muhasebeDeneyimSuresi = muhasebeDeneyimSuresi;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(1));
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        MuhasebePersoneli.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMuhasebeDeneyimSuresi() {
        return muhasebeDeneyimSuresi;
    }

    public void setMuhasebeDeneyimSuresi(int muhasebeDeneyimSuresi) {
        this.muhasebeDeneyimSuresi = muhasebeDeneyimSuresi;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "id=" + id +
                ", muhasebeDeneyimSuresi=" + muhasebeDeneyimSuresi +
                "} " + super.toString();
    }
}