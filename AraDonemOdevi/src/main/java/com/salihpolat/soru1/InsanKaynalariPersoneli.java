package com.salihpolat.soru1;

import java.time.LocalDate;

public class InsanKaynalariPersoneli extends Personel {

    private static int idSayar = 1;
    private int id;
    private int personelDosyaSayisi;
    PersonelRepositories personelRepositories = new PersonelRepositories();

    public InsanKaynalariPersoneli(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi, int personelDosyaSayisi) {
        super(ad, soyad, yas, maas, iseBaslamaTarihi);
        this.id = idSayar++;
        this.personelDosyaSayisi = personelRepositories.personelListesi().size();
        PersonelRepositories.getPersoneller().add(this);
        PersonelRepositories.getPersonelById().put(this.id,this);
        setDepartman(PersonelRepositories.getDepartmanlar().get(1));
    }

    public static int getIdSayar() {
        return idSayar;
    }

    public static void setIdSayar(int idSayar) {
        InsanKaynalariPersoneli.idSayar = idSayar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonelDosyaSayisi() {
        return personelDosyaSayisi;
    }

    public void setPersonelDosyaSayisi(int personelDosyaSayisi) {
        this.personelDosyaSayisi = personelDosyaSayisi;
    }

    @Override
    public String toString() {
        return "InsanKaynalariPersoneli{" +
                "id=" + id +
                ", personelDosyaSayisi=" + personelDosyaSayisi +
                ", personelRepositories=" + personelRepositories +
                "} " + super.toString();
    }
}