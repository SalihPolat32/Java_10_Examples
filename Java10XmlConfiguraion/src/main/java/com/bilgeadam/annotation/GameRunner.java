package com.bilgeadam.annotation;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    IRunable game;

    public GameRunner(IRunable game) {

        this.game = game;
    }

    public void run() {

        System.out.println("Oyun Çalışıyor ==> " + game.getClass().getSimpleName());

        game.up();

        game.down();

        game.left();

        game.right();
    }
}