package com.bilgeadam.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.auth-exchange}")
    private String exchange;

    @Value("${rabbitmq.register-binding-key}")
    private String registerBindingKey;  // unique --> Her bir mesaj isteğine göre özel üretilmelidir.

    @Value("${rabbitmq.register-queue}")
    private String registerQueueName;  // unique --> Her bir mesaj isteğine göre özel üretilmelidir.

    @Value("${rabbitmq.activation-binding-key}")
    private String activationBindingKey;

    @Value("${rabbitmq.activation-queue}")
    private String activationQueueName;

    @Value("${rabbitmq.mail-queue}")
    private String mailQueueName;

    @Value("${rabbitmq.mail-binding-key}")
    private String mailBindingKey;

    @Bean
    DirectExchange exchange() {

        return new DirectExchange(exchange);
    }

    // Register İşlemleri
    @Bean
    Queue registerQueue() {

        return new Queue(registerQueueName);
    }

    @Bean
    public Binding bindingRegister(final Queue registerQueue, final DirectExchange exchange) {

        return BindingBuilder.bind(registerQueue).to(exchange).with(registerBindingKey);
    }

    // activation İşlemleri
    @Bean
    public Queue activationQueue() {

        return new Queue(activationQueueName);
    }

    @Bean
    public Binding bindingActivation(final Queue activationQueue, final DirectExchange exchange) {

        return BindingBuilder.bind(activationQueue).to(exchange).with(activationBindingKey);
    }

    // Mail İşlemleri
    @Bean
    public Queue mailQueue() {

        return new Queue(mailQueueName);
    }

    @Bean
    public Binding bindingMail(final Queue mailQueue, final DirectExchange exchange) {

        return BindingBuilder.bind(mailQueue).to(exchange).with(mailBindingKey);
    }
}