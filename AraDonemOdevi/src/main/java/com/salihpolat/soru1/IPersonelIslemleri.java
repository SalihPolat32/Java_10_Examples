package com.salihpolat.soru1;

import java.util.List;

public interface IPersonelIslemleri {

    void personelEkle();
    void personelGuncelle();
    void personelSil(Personel personel);
    List<Personel> personelListesi();
    //Personel findById(int id);
    //void deleteById(int id);
    void departmanEkle();
    void departmanListesi();
    void defaultDepartmanlar();
    void personelMaasTanimlama();
    void odemeListesi();
    void departmanPersonelListesi();
    void enCokPersonelBulunanDepartman();
    void departmanlaraGoreMaasOrtalamalari();
    void mudurlerinSorumluOlduguDepartmanlar();
    void iseGirisTarihineGore();
    void ayniGunBaslayanlar();

}