package com.bilgeadam.ioconfigwithannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    IRunable game;

    // Constructor Injection
/*
    public GameRunner(IRunable game) {

        this.game = game;
    }
 */

    public void run() {

        System.out.println("Oyun Çalışıyor ==> " + game.getClass().getSimpleName());

        game.up();

        game.down();

        game.left();

        game.right();
    }
}