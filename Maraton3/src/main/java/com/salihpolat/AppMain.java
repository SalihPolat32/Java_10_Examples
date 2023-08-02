package com.salihpolat;

import com.salihpolat.controller.AracController;
import com.salihpolat.controller.KiralamaController;
import com.salihpolat.controller.KisiController;
import com.salihpolat.model.Arac;
import com.salihpolat.model.Kiralama;
import com.salihpolat.model.Kisi;
import com.salihpolat.model.enums.EAracDurum;

import java.util.List;
import java.util.Scanner;

public class AppMain {

    static Scanner scanner = new Scanner(System.in);
    static AracController aracController;
    static KiralamaController kiralamaController;
    static KisiController kisiController;

    public AppMain() {
        this.aracController = new AracController();
        this.kiralamaController = new KiralamaController();
        this.kisiController = new KisiController();
    }

    public static void main(String[] args) {

            AppMain appMain = new AppMain();
            appMain.anaMenu();
    }

    public void anaMenu() {

        int secim = 0;

        do {
            System.out.println("*******************************************");
            System.out.println("******** ARAÇ KİRALAMA UYGULAMASI *********");
            System.out.println("*******************************************");

            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Ara");
            System.out.println("3- Kişi Ekle");
            System.out.println("4- Arac Kirala");
            System.out.println("5- Rapor");
            System.out.println("0- Çıkış");
            System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:");

            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Arac Ekle Seçildi..");
                    aracEkle();
                    break;

                case 2:
                    System.out.println("Arac Ara Seçildi..");
                    aracAra();
                    break;

                case 3:
                    System.out.println("Kisi Ekle Seçildi..");
                    kisiEkle();
                    break;

                case 4:
                    System.out.println("Arac Kirala Seçildi..");
                    aracKirala();
                    break;

                case 5:
                    System.out.println("Rapor Seçildi..");
                    rapor();
                    break;

                case 0:
                    System.out.println("Çıkış Yapılıyor...");
                    break;

                default:
                    break;
            }
        } while (secim != 0);
    }

    public void aracEkle() {

        System.out.println("Lütfen Aracın Markasını Giriniz:");
        String marka = scanner.nextLine();

        System.out.println("Lütfen Aracın Modelini Giriniz:");
        String model = scanner.nextLine();

        System.out.println("Lütfen Aracın Üretim Yılını Giriniz:");
        String uretimYili = scanner.nextLine();

        Arac arac = Arac.builder().marka(marka).model(model).uretimYili(uretimYili).build();

        aracController.aracEkleme(arac);

        System.out.println("Araç Başarıyla Eklendi..");
    }

    public void aracAra() {

        System.out.println("Lütfen Araç id'sini Giriniz:");
        Long id = scanner.nextLong();

        Arac arac = aracController.idyeGoreAracBulma(id);
        System.out.println(arac);
    }

    public void aracKirala() {

        System.out.println("Lütfen Araç id'sini Giriniz:");
        Long id = scanner.nextLong();

        Arac arac = aracController.idyeGoreAracBulma(id);
        arac.setDurum(EAracDurum.KIRADA.KIRADA);
        System.out.println("Araç Bilgisi: " + arac);
        System.out.println("Lütfen Kiralamak İsteyen Kişinin id'sini Giriniz:");
        Long kisiId = scanner.nextLong();
        Kisi kisi = kisiController.idyeGoreKisiGetir(kisiId);
        System.out.println("Kişi Bilgisi:" + kisi);

        Kiralama kiralama = Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .build();

        kiralamaController.kiralamaEkle(kiralama);

        System.out.println("Araç Başarıyla Kiralandı..");
    }

    public void kisiEkle() {

        System.out.println("Lütfen İsminizi Ve Soyisminizi Giriniz:");
        String isimSoyisim = scanner.nextLine();

        Kisi kisi = Kisi.builder()
                .isimSoyisim(isimSoyisim)
                .build();

        kisiController.kisiEkle(kisi);

        System.out.println("Kişi Başarıyla Eklendi..");
    }

    public void rapor() {

        int secim = 0;

        do {

            System.out.println("**************************");
            System.out.println("******** RAPORLAR ********");
            System.out.println("**************************");

            System.out.println("1- Şu An Kirada Olan Araçlar");
            System.out.println("2- Boşta/Müsait Olan Araçlar");
            System.out.println("3- Herhangi Bir Müşterinin Kiraladığı Araçlar");
            System.out.println("0- Çıkış");
            System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Şu An Kirada Olan Araçlar Aranıyor...");
                    kiradakiAraclar();
                    break;

                case 2:
                    System.out.println("Boşta/Müsait Olan Araçlar Aranıyor...");
                    musaitAraclar();
                    break;

                case 3:
                    System.out.println("Herhangi Bir Müşterinin Kiraladığı Araclar Aranıyor...");
                    System.out.println("Kiralamaları Aranacak kişi id Giriniz:");
                    herhangiBirMusterininKiraladigiAraclar(scanner.nextLong());
                    break;

                case 0:
                    System.out.println("Çıkış Yapılıyor...");
                    break;

                default:
                    break;
            }
        } while (secim != 0);
    }

    public void kiradakiAraclar() {

        List<Arac> araclerListesi = aracController.kiradakiAracler();
        for (Arac arac : araclerListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }

    public void musaitAraclar() {

        List<Arac> araclarListesi = aracController.musaitAracler();

        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }

    public void herhangiBirMusterininKiraladigiAraclar(Long id) {

        List<Arac> araclarListesi = kiralamaController.kisiIdsineGorekiralananAraclar(id);

        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }
}