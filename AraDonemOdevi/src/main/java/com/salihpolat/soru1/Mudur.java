package com.salihpolat.soru1;

import java.time.LocalDate;

public class Mudur extends Personel {

    private static int idSayar = 1;
    private int id;
    private Departman sorumluDepartmanlar;

    public Mudur(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, Departman departman) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.sorumluDepartmanlar = departman;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(2));
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        Mudur.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Departman getSorumluDepartmanlar() {
        return sorumluDepartmanlar;
    }

    public void setSorumluDepartmanlar(Departman sorumluDepartmanlar) {
        this.sorumluDepartmanlar = sorumluDepartmanlar;
    }

    @Override
    public String toString() {
        return "Mudur{" +
                "id=" + id +
                ", sorumluDepartmanlar=" + sorumluDepartmanlar +
                "} " + super.toString();
    }
}