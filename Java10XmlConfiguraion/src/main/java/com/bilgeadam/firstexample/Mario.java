package com.bilgeadam.firstexample;

public class Mario implements IRunable {

    public void up() {
        System.out.println("Zıpla...");
    }

    public void down() {
        System.out.println("Bir Deliğe Gir...");
    }

    public void left() {
        System.out.println("Geri Dön...");
    }

    public void right() {
        System.out.println("Hızlan...");
    }
}