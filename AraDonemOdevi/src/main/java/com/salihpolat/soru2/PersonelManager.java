package com.salihpolat.soru2;

import java.util.*;
import java.util.stream.Collectors;

public class PersonelManager {

    public static void main(String[] args) {

        List<Personel> personelListesi = new ArrayList<>();

        personelListesi.add(new Personel("Ahmet", 30));
        personelListesi.add(new Personel("Ayşe", 25));
        personelListesi.add(new Personel("Mehmet", 35));
        personelListesi.add(new Personel("Fatma", 28));
        personelListesi.add(new Personel("Ali", 32));
        personelListesi.add(new Personel("Zeynep", 29));
        personelListesi.add(new Personel("Mustafa", 40));
        personelListesi.add(new Personel("Esra", 27));
        personelListesi.add(new Personel("Ömer", 33));
        personelListesi.add(new Personel("Gül", 26));
        personelListesi.add(new Personel("Hakan", 31));
        personelListesi.add(new Personel("Elif", 24));
        personelListesi.add(new Personel("Serkan", 38));
        personelListesi.add(new Personel("Deniz", 23));
        personelListesi.add(new Personel("Sevgi", 30));
        personelListesi.add(new Personel("Murat", 37));
        personelListesi.add(new Personel("Selin", 22));
        personelListesi.add(new Personel("Cem", 29));
        personelListesi.add(new Personel("Pınar", 36));
        personelListesi.add(new Personel("Emre", 27));

        System.out.println("********************* Soru 01 *********************");

        personelListesi.stream().filter(x -> (x.getYas() > 30)).forEach(x -> System.out.println("30 Yaşından Büyük Personeller: " + x));

        System.out.println("--------------------------------------------------");

        System.out.println("********************* Soru 02 *********************");

        long aileBaslayanlar = personelListesi.stream().filter(x -> x.getAd().startsWith("A")).count();
        System.out.println("Adı 'A' Harfi İle Başlayan Personel Sayısı: " + aileBaslayanlar);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 03 *********************");

        String enYasliPersonel = personelListesi.stream().max(Comparator.comparing(x -> x.getYas())).map(x -> x.getAd()).toString();
        System.out.println("En Yaşlı Personel: " + enYasliPersonel);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 04 *********************");

        personelListesi.stream().filter(x -> x.getAd().equals("Ali")).map(x -> x.getYas()).forEach(x -> System.out.println("Ali'nin Yaşı: " + x));

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 05 *********************");

        List<String> enKucukUcKisi = personelListesi.stream().sorted(Comparator.comparing(x -> x.getYas())).limit(3).map(x -> x.getAd()).collect(Collectors.toList());
        System.out.println("Yaşı En Küçük 3 Kişi: " + enKucukUcKisi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 06 *********************");

        long yirmibesOtuzbesArasiPersonelSayisi = personelListesi.stream().filter(x -> (x.getYas() >=25 && x.getYas() <= 35)).count();
        System.out.println("Yaşları 25 ile 35 Arasında Olan Personel Sayısı: " + yirmibesOtuzbesArasiPersonelSayisi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 07 *********************");

        personelListesi.stream().filter(x -> (x.getAd().length() > 4)).forEach(x -> System.out.println("Adı 4 Harften Uzun Kişiler: " + x.getAd()));

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 08 *********************");

        List<String> enYasliIkiKisi = personelListesi.stream().sorted(Comparator.comparingInt(Personel::getYas).reversed()).limit(2).map(Personel::getAd).toList();
        System.out.println("En Yaşlı 2 Personel: " + enYasliIkiKisi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 09 *********************");

        personelListesi.stream().filter(x -> x.getAd().endsWith("a")).forEach(x -> System.out.println("Adı 'a' Harfi İle Bitenler: " + x.getAd()));

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 10 *********************");

        double isimUzunluguOrtalamasi = personelListesi.stream().mapToDouble(x -> x.getAd().length()).average().getAsDouble();
        System.out.println("İsimlerin Uzunlukları Ortalamasi: " + isimUzunluguOrtalamasi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 11 *********************");

        int enUzunIsimliPersonelinYasi = personelListesi.stream().max(Comparator.comparing(x -> x.getAd().length())).map(x -> x.getYas()).get();
        System.out.println("En Uzun İsimli Personelin Yaşı: " + enUzunIsimliPersonelinYasi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 12 *********************");

        boolean ahmetIsmiVarMi = personelListesi.stream().map(x -> x.getAd()).anyMatch(x -> x.equals("Ahmet"));
        System.out.println("Ahmet İsmi Var Mı?: " + ahmetIsmiVarMi);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 13 *********************");

        List<String> isimleriTersDonmusAlfabetikSiraliListe = personelListesi.stream().map(Personel::getAd).map(str -> new StringBuilder(str).reverse().toString()).sorted().toList();
        System.out.println("İsimleri Ters çevirilmiş ve Alfabetik Olarak Sıralanmış Liste: " + isimleriTersDonmusAlfabetikSiraliListe);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 14 *********************");

        List<String> ismindeEHarfiGecenler = personelListesi.stream().map(Personel::getAd).filter(ad -> ad.contains("e") || ad.contains("E")).collect(Collectors.toList());;
        System.out.println("İsminde 'E' Hafri Geçen İsimler: " + ismindeEHarfiGecenler);

        System.out.println("---------------------------------------------------");

        System.out.println("********************* Soru 15 *********************");

        Map<String, Integer> enKucukPersonel = personelListesi.stream().min((p1, p2) -> Integer.compare(p1.getYas(), p2.getYas())).map(p -> Map.of(p.getAd(), p.getYas())).orElse(new HashMap<>());
        System.out.println("Yaşı En Küçük Personel: " + enKucukPersonel);

        System.out.println("---------------------------------------------------");
    }
}