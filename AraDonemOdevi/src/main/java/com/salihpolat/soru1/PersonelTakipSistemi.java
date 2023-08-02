package com.salihpolat.soru1;

import java.util.Scanner;

public class PersonelTakipSistemi {

    private static PersonelTakipSistemi personelTakipSistemi;
    private static PersonelRepositories personelRepositories = new PersonelRepositories();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        personelTakipSistemi = new PersonelTakipSistemi();

        personelRepositories.defaultDepartmanlar();

        boolean islem = true;
        do {
            System.out.println("************************************************************");
            System.out.println("*************** PERSONEL TAKİP SİSTEMİ *********************");
            System.out.println("************************************************************");
            System.out.println("1. Personel İşlemleri");
            System.out.println("2. Muhasebe İşlemleri");
            System.out.println("3. Raporlamalar");
            System.out.println("4. Çıkış");
            System.out.println("************************************************************");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçin (1-4): ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    personelIslemleriMenu();
                    break;
                case 2:
                    muhasebeIslemleriMenu();
                    break;
                case 3:
                    raporlamalarMenu();
                    break;
                case 4:
                    islem = false;
                    break;
                default:
                    System.out.println("Geçersiz Bir Seçim Yaptınız. Lütfen Tekrar Deneyin.");
                    break;
            }
        } while (islem);
    }

    public static void personelIslemleriMenu() {

        boolean islem = true;
        do {
            System.out.println("************************************************************");
            System.out.println("1. Personel Ekleme");
            System.out.println("2. Personel Listesi");
            System.out.println("3. Personel Düzenleme");
            System.out.println("4. Departman Ekleme");
            System.out.println("5. Departman Listesi");
            System.out.println("6. Geri");
            System.out.println("************************************************************");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçin (1-6): ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    // Personel Ekleme
                    personelRepositories.personelEkle();
                    break;
                case 2:
                    // Personel Listesi
                    personelRepositories.personelListesi().forEach(System.out::println);
                    break;
                case 3:
                    // Personel Düzenleme
                    personelRepositories.personelGuncelle();
                    break;
                case 4:
                    // Departman Ekleme
                    personelRepositories.departmanEkle();
                    break;
                case 5:
                    // Departman Listesi
                    personelRepositories.departmanListesi();
                    break;
                case 6:
                    islem = false;
                    break;
                default:
                    System.out.println("Geçersiz Bir Seçim Yaptınız. Lütfen Tekrar Deneyin.");
                    break;
            }
        } while (islem);
    }

    public static void muhasebeIslemleriMenu() {

        boolean islem = true;
        do {
            System.out.println("************************************************************");
            System.out.println("1. Maaş Personel Tanımlama");
            System.out.println("2. Ödeme Listesi");
            System.out.println("3. Geri");
            System.out.println("************************************************************");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçin (1-3): ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    // Personel Maaş Tanımlama
                    personelRepositories.personelMaasTanimlama();
                    break;
                case 2:
                    // Ödeme Listesi
                    personelRepositories.odemeListesi();
                    break;
                case 3:
                    islem = false;
                    break;
                default:
                    System.out.println("Geçersiz Bir Seçim Yaptınız. Lütfen Tekrar Deneyin.");
                    break;
            }
        } while (islem);
    }

    public static void raporlamalarMenu() {

        boolean islem = true;
        while (islem) {
            System.out.println("************************************************************");
            System.out.println("1. Departman Personel Listesi");
            System.out.println("2. En Çok Personel Bulunan Departman");
            System.out.println("3. Departmanlara Göre Maaş Ortalamaları");
            System.out.println("4. Müdürlerin Sorumlu Olduğu Departman Listesi");
            System.out.println("5. Kayıt Tarihlerine Göre Personellerin Sıralı Listesi");
            System.out.println("6. Aynı Gün İçinde İşe Başlayan Personellerin Listesi");
            System.out.println("7. Geri");
            System.out.println("************************************************************");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçin (1-7): ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    // Departman Personel Listesi
                    personelRepositories.departmanPersonelListesi();
                    break;
                case 2:
                    // En Çok Personel Bulunan Departman
                    personelRepositories.enCokPersonelBulunanDepartman();
                    break;
                case 3:
                    // Departmanlara Göre Maaş Ortalamaları
                    personelRepositories.departmanlaraGoreMaasOrtalamalari();
                    break;
                case 4:
                    // Müdürlerin Sorumlu Olduğu Departman Listesi
                    personelRepositories.mudurlerinSorumluOlduguDepartmanlar();
                    break;
                case 5:
                    // İşe Giriş Tarihlerine Göre Personellerin Sıralı Listesi
                    personelRepositories.iseGirisTarihineGore();
                    break;
                case 6:
                    // Aynı Gün İçinde İşe Başlayan Personellerin Listesi
                    personelRepositories.ayniGunBaslayanlar();
                    break;
                case 7:
                    islem = false;
                    break;
                default:
                    System.out.println("Geçersiz Bir Seçim Yaptınız. Lütfen Ttekrar Deneyin.");
                    break;
            }
        }
        scanner.close();
    }
}