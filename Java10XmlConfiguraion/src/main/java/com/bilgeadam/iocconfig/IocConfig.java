package com.bilgeadam.iocconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class IocConfig {

    @Bean
    public String name() {
        return "Mustafa";
    }

    @Bean
    public Integer toplam() {
        return 8;
    }

    @Bean
    @Primary
    public IRunable getContra() {
        return new Contra();
    }

    @Bean
    public IRunable getMario() {
        return new Mario();
    }

    @Bean
    public IRunable getPacman() {
        return new Pacman();
    }

    @Bean
    public GameRunner gameRunner() {
        return new GameRunner(getPacman());
    }
}