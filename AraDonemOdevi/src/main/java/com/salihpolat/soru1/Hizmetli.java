package com.salihpolat.soru1;

import java.time.LocalDate;

public class Hizmetli extends Personel {

    private static int idSayar = 1;
    private int id;
    private String temizlikBirimi;

    public Hizmetli(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, String temizlikBirimi) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.temizlikBirimi = temizlikBirimi;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(0));
    }

    public String getTemizlikBirimi() {
        return temizlikBirimi;
    }

    public void setTemizlikBirimi(String temizlikBirimi) {
        this.temizlikBirimi = temizlikBirimi;
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        Hizmetli.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hizmetli{" +
                "id=" + id +
                ", temizlikBirimi='" + temizlikBirimi + '\'' +
                "} " + super.toString();
    }
}