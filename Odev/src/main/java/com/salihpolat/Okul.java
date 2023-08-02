package com.salihpolat;

public class Okul {

    private String ad = "Bilge Adam";
    private Ogretmen ogretmen;
    private Memur memur;
    private Ogrenci ogrenci;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Ogretmen getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

    public Memur getMemur() {
        return memur;
    }

    public void setMemur(Memur memur) {
        this.memur = memur;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    @Override
    public String toString() {
        return "Okul{" +
                "ad='" + ad + '\'' +
                ", ogretmen=" + ogretmen +
                ", memur=" + memur +
                ", ogrenci=" + ogrenci +
                '}';
    }
}