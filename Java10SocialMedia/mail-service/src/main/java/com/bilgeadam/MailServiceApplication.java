package com.bilgeadam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MailServiceApplication.class);
    }

    // Deneme Amaçlı Kod
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public  void sendMail(){

//        SimpleMailMessage mailMessage=new SimpleMailMessage();

//        mailMessage.setFrom("${java10_mail}");

//        mailMessage.setTo("java9and10@gmail.com");

//        mailMessage.setSubject("AKTIVASYON KODUNUZ...");

//        mailMessage.setText("lkD345");

//        javaMailSender.send(mailMessage);
//    }
}