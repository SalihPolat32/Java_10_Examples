package com.salihpolat.soru1;

import java.time.LocalDate;

public class Personel {

    private String ad;
    private String soyad;
    private int yas;
    private double maas;
    private LocalDate iseBaslamaTarihi;
    private Departman departman;

    public Personel() {
    }

    public Personel(String ad, String soyad, int yas, double maas, LocalDate iseBaslamaTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.maas = maas;
        this.iseBaslamaTarihi = iseBaslamaTarihi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public LocalDate getIseBaslamaTarihi() {
        return iseBaslamaTarihi;
    }

    public void setIseBaslamaTarihi(LocalDate iseBaslamaTarihi) {
        this.iseBaslamaTarihi = iseBaslamaTarihi;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", yas=" + yas +
                ", maas=" + maas +
                ", iseBaslamaTarihi=" + iseBaslamaTarihi +
                ", departman=" + departman +
                '}';
    }
}