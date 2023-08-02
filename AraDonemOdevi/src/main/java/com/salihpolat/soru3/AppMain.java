package com.salihpolat.soru3;

public class AppMain {

    public static void main(String[] args) {

        MyArrayList<String> myList = new MyArrayList<>();

        myList.add("Elma");
        myList.add("Muz");
        myList.add("Karpuz");
        myList.add("Kavun");
        myList.add("Vişne");
        myList.add("Kiraz");
        myList.add("Erik");
        myList.add("Şeftali");
        myList.add("Kayısı");
        myList.add("Armut");
        myList.add("Ayva");

        myList.add(1, "Mandalina");

        String meyve = myList.get(2);
        System.out.println("Meyve İndeksi: " + meyve);

        myList.set(0, "Nar");

        myList.remove(3);

        boolean meyveVarMi = myList.contains("Armut");
        System.out.println("Elma Var Mı?: " + meyveVarMi);

        int listeUzunlugu = myList.size();
        System.out.println("Listenin Uzunluğu: " + listeUzunlugu);

        boolean listeBosMu = myList.isEmpty();
        System.out.println("Liste Boş Mu?: " + listeBosMu);
    }
}