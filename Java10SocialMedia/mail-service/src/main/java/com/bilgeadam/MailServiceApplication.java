package com.bilgeadam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailServiceApplication {

    // Deneme Amaçlı Kod
    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {

        SpringApplication.run(MailServiceApplication.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("${java10_mail}");

        mailMessage.setTo("java9and10@gmail.com");

        mailMessage.setSubject("AKTIVASYON KODUNUZ...");

        mailMessage.setText("lkD345");

        javaMailSender.send(mailMessage);
    }
}