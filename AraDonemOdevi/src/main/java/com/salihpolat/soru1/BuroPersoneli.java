package com.salihpolat.soru1;

import java.time.LocalDate;

public class BuroPersoneli extends Personel {

    private static int idSayar = 1;
    private int id;
    private String bilgisayarYetenekleri;

    public BuroPersoneli(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, String bilgisayarYetenekleri) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.bilgisayarYetenekleri = bilgisayarYetenekleri;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(1));
    }

    public String getBilgisayarYetenekleri() {
        return bilgisayarYetenekleri;
    }

    public void setBilgisayarYetenekleri(String bilgisayarYetenekleri) {
        this.bilgisayarYetenekleri = bilgisayarYetenekleri;
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        BuroPersoneli.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BuroPersoneli{" +
                "id=" + id +
                ", bilgisayarYetenekleri='" + bilgisayarYetenekleri + '\'' +
                "} " + super.toString();
    }
}