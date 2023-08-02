package com.salihpolat;

import java.util.ArrayList;
import java.util.List;

public class Ogrenci implements IKisi {

    private String ogrenciNo;
    private String ogrenciAdi;
    private int sinifSeviyesi;
    private EDers ders;
    private List<EDers> dersListesi;
    private List<Double> notlar = new ArrayList<>();


    public Ogrenci(String ogrenciNo, String ogrenciAdi, int sinifSeviyesi, EDers ders) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAdi = ogrenciAdi;
        this.sinifSeviyesi = sinifSeviyesi;
        this.dersListesi = new ArrayList<>();
        this.dersListesi.add(ders);
    }

    public List<Double> getNotlar() {
        return notlar;
    }

    public void setNotlar(List<Double> notlar) {
        this.notlar = notlar;
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public int getSinifSeviyesi() {
        return sinifSeviyesi;
    }

    public void setSinifSeviyesi(int sinifSeviyesi) {
        this.sinifSeviyesi = sinifSeviyesi;
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
        return "Ogrenci{" +
                "ogrenciNo='" + ogrenciNo + '\'' +
                ", ogrenciAdi='" + ogrenciAdi + '\'' +
                ", sinifSeviyesi=" + sinifSeviyesi +
                ", dersListesi=" + dersListesi +
                ", notlar=" + notlar +
                '}';
    }

    @Override
    public void raporAl() {
        System.out.println("Öğrenci Rapor Aldı.");
    }
}