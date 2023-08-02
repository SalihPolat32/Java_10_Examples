package com.salihpolat;

public class OkulPersoneli {

    private String id;
    private String ad;
    private String gorev;
    private double maas;

    public OkulPersoneli(String id, String ad, double maas) {
        this.id = id;
        this.ad = ad;
        this.maas = maas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "OkulPersoneli{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", gorev='" + gorev + '\'' +
                ", maas=" + maas +
                '}';
    }

    public void izinHakki() {
        System.out.println(getGorev() + "İzin Aldı.");
    }
}