package com.bilgeadam.annotation.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contra")
public class ContraQualifier implements IRunableQualifier {

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