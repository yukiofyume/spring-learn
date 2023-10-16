package com.dodo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lwh
 * @date 2023-09-24 15:08:39
 * @describe --
 */
@Configuration
public class DirectRabbitMQConfig {

    @Bean
    public Queue testDirectQueue() {
        return new Queue("testDirectQueue", true);
    }

    @Bean
    public DirectExchange testDirectExchange() {
        return new DirectExchange("testDirectExchange", true,false);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue())
                .to(testDirectExchange())
                .with("testDirectRouting");
    }

    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
}
