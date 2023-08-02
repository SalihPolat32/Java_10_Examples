package com.salihpolat.soru1;

import java.time.LocalDate;

public class TeknikPersonel extends Personel {

    private static int idSayar = 1;
    private int id;
    private String uzmanlikAlani;

    public TeknikPersonel(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, String uzmanlikAlani) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.uzmanlikAlani = uzmanlikAlani;
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(0));
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        TeknikPersonel.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUzmanlikAlani() {
        return uzmanlikAlani;
    }

    public void setUzmanlikAlani(String uzmanlikAlani) {
        this.uzmanlikAlani = uzmanlikAlani;
    }

    @Override
    public String toString() {
        return "TeknikPersonel{" +
                "id=" + id +
                ", uzmanlikAlani='" + uzmanlikAlani + '\'' +
                "} " + super.toString();
    }
}