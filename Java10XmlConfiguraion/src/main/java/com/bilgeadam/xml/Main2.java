package com.bilgeadam.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        GameRunner gameRunner = context.getBean("gamerunner", GameRunner.class);
        gameRunner.run();

        System.out.println(gameRunner.username);
        System.out.println(gameRunner.password);
    }
}