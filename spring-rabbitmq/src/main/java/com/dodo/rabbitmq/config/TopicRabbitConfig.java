package com.dodo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwh
 * @date 2023-09-26 10:31:05
 * @describe --
 */
@Configuration
public class TopicRabbitConfig {

    public final static String MAN = "topic.man";
    public final static String WOMAN = "topic.woman";

    @Bean
    public Queue firstQueue() {
        return new Queue(MAN);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(WOMAN);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue())
                .to(topicExchange())
                .with(MAN);
    }

    @Bean
    public Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue())
                .to(topicExchange())
                .with("topic.#");
    }
}
