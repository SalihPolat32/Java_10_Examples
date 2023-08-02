package com.bilgeadam.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class Contra implements IRunable {

    public void up() {
        System.out.println("Zıpla...");
    }

    public void down() {
        System.out.println("Eğil...");
    }

    public void left() {
        System.out.println("Geri Git...");
    }

    public void right() {
        System.out.println("Ateş Et...");
    }
}