package com.salihpolat.soru1;

import java.util.ArrayList;
import java.util.List;

public class Departman {

    private String isim;
    private List<Personel> departman;

    public Departman() {
    }

    public Departman(String isim) {
        this.isim = isim;
        this.departman = new ArrayList<>();
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Personel> getDepartman() {
        return departman;
    }

    public void setDepartman(List<Personel> departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "isim='" + isim +
                '}';
    }
}