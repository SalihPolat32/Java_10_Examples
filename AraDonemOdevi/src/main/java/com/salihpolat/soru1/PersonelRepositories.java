package com.salihpolat.soru1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PersonelRepositories implements IPersonelIslemleri {

    Scanner scanner = new Scanner(System.in);
    private static List<Departman> departmanlar = new ArrayList();
    private static List<Personel> personeller = new ArrayList<>();
    private static Map<Integer, Personel> personelById = new HashMap<>();

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static List<Departman> getDepartmanlar() {
        return departmanlar;
    }

    public static void setDepartmanlar(List<Departman> departmanlar) {
        PersonelRepositories.departmanlar = departmanlar;
    }

    public static List<Personel> getPersoneller() {
        return personeller;
    }

    public static void setPersoneller(List<Personel> personeller) {
        PersonelRepositories.personeller = personeller;
    }

    public static Map<Integer, Personel> getPersonelById() {
        return personelById;
    }

    public static void setPersonelById(Map<Integer, Personel> personelById) {
        PersonelRepositories.personelById = personelById;
    }

    @Override
    public void personelEkle() {

        System.out.print("Personel Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Personel Soyadı: ");
        String soyad = scanner.nextLine();
        System.out.print("Personel Yaşı: ");
        int yas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Personel Maaşı: ");
        double maas = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Personel İşe Başlama Tarihi (dd-MM-yyyy): ");
        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate iseBaslamaTarihi = LocalDate.parse(date, formatter);



        for (Departman departman : departmanlar) {
            System.out.println(departman);
        }

        System.out.print("Seçilen Departmanı Yazınız: ");
        String girilenDepartman = scanner.nextLine();
        Departman secilenDepartman = null;

        int secilenDepartmanIndex = -1;

        for (int i = 0; i < departmanlar.size(); i++) {
            if (departmanlar.get(i).getIsim().equals(girilenDepartman)) {
                secilenDepartmanIndex = i;
                break;
            }
        }

        if (secilenDepartmanIndex != -1) {
            secilenDepartman = departmanlar.get(secilenDepartmanIndex);
        } else {
            System.out.println("Seçilen Departman Bulunamadı.");
        }

        Personel personel = new Personel(ad, soyad, yas, maas, iseBaslamaTarihi);

        if (girilenDepartman != null) {
            personel.setDepartman(secilenDepartman);
        }
        personeller.add(personel);
        System.out.println("Personel Başarıyla Eklendi.");
    }

    @Override
    public void personelGuncelle() {

        Personel personel = new Personel();
        personeller.stream()
                .findFirst()
                .ifPresent(p -> {
                    p.setAd(personel.getAd());
                    p.setSoyad(personel.getSoyad());
                    p.setYas(personel.getYas());
                    p.setMaas(personel.getMaas());
                    p.setIseBaslamaTarihi(personel.getIseBaslamaTarihi());
                    p.setDepartman(personel.getDepartman());
                });
    }

    @Override
    public void personelSil(Personel personel) {
        personeller.remove(personel);
    }

    @Override
    public List<Personel> personelListesi() {
        return personeller;
    }

    @Override
    public void departmanEkle() {



        System.out.print("Departman Adı: ");
        String depAdi;
        departmanlar.add(new Departman(depAdi = scanner.nextLine()));
        System.out.println("Departman Başarıyla Eklendi.");
    }


    @Override
    public void departmanListesi() {

        System.out.println("Departman Listesi:");
        departmanlar.forEach(System.out::println);
    }

    @Override
    public void defaultDepartmanlar() {
        departmanlar.add(new Departman("Mavi Yaka"));
        departmanlar.add(new Departman("Beyaz Yaka"));
        departmanlar.add(new Departman("Yönetim"));
    }

    @Override
    public void personelMaasTanimlama() {

        System.out.print("Personel Adı: ");
        String personelAdi = scanner.nextLine();
        System.out.print("Maaş Miktarı: ");
        double maas = scanner.nextDouble();
        scanner.nextLine();

        Personel personel = new Personel();

        if (personeller.contains(personelAdi)) {
            personel.setMaas(maas);
            System.out.println("Personel Maaş Tanımlama İşlemi Başarılı.");
        } else {
            System.out.println("Belirtilen İsimde Personel Bulunamadı.");
        }
    }

    @Override
    public void odemeListesi() {

        personeller.stream().map(x -> x.getMaas()).forEach(System.out::println);
    }

    @Override
    public void departmanPersonelListesi() {

        Map<Departman, List<Personel>> departmandakiPersoneller = new HashMap<>();
        for (Departman departman : departmanlar
        ) {
            departmandakiPersoneller.put(departman, departman.getDepartman());
        }

        departmandakiPersoneller.forEach((departman, list) ->
        {
            System.out.println("Departman => " + departman.getIsim());
            System.out.println("Personeller => " + list);
            list.stream().map(x -> x.getAd()).forEach(System.out::println);
        });
    }

    @Override
    public void enCokPersonelBulunanDepartman() {

        Optional<Departman> enCokPersonel = departmanlar.stream().max(Comparator.comparingInt(x -> x.getDepartman().size()));
        if (enCokPersonel.isPresent()) {
            Departman departman = enCokPersonel.get();
            System.out.println("En Çok Personele Sahip Departman: " + departman.getIsim());
            System.out.println("Personel Sayısı: " + departman.getDepartman().size());

        } else {
            System.out.println("Departmanlar Boş.");
        }
    }

    @Override
    public void departmanlaraGoreMaasOrtalamalari() {

        Departman departman1 = new Departman();

        for (int i = 0; i < departmanlar.size(); i++) {

            Departman departman = departmanlar.get(i);
            i++;

            double departmanMaasOrtalamalari = departman1.getDepartman().stream().mapToDouble(x -> x.getMaas()).average().getAsDouble();

            Map<Departman, Double> departmanlaraGoreMaasOrtalamalari = new HashMap<>();
            System.out.println("Departmanlara Göre Maaş Ortalamaları:");
            for (Map.Entry<Departman, Double> entry : departmanlaraGoreMaasOrtalamalari.entrySet()) {
                departman = entry.getKey();
                Double maasOrtalamasi = entry.getValue();
                System.out.println("Departman: " + departman + ", Maaş Ortalaması: " + maasOrtalamasi);
            }
        }
    }

    @Override
    public void mudurlerinSorumluOlduguDepartmanlar() {

        List<Personel> mudurDepartmanlari = personeller.stream().filter(x -> x.getDepartman().equals(departmanlar)).collect(Collectors.toList());
        System.out.println(mudurDepartmanlari);
    }

    @Override
    public void iseGirisTarihineGore() {

        List iseGirisTarihineGore = personeller.stream().map(x -> x.getIseBaslamaTarihi()).sorted().collect(Collectors.toList());
        System.out.println("İşe Giriş Tarihine Göre Personel Listesi: " + iseGirisTarihineGore);
    }

    @Override
    public void ayniGunBaslayanlar() {

        List<Personel> ayniGunBaslayanPersoneller = new ArrayList<>();

        for (Personel personel1 : personeller) {
            for (Personel personel2 : personeller) {
                if (personel1 != personel2 && personel1.getIseBaslamaTarihi().isEqual(personel2.getIseBaslamaTarihi())) {
                    ayniGunBaslayanPersoneller.add(personel1);
                    ayniGunBaslayanPersoneller.add(personel2);
                }
            }
        }
        System.out.println("Aynı Gün İşe Başlayan Personeller: " + ayniGunBaslayanPersoneller);
    }
}