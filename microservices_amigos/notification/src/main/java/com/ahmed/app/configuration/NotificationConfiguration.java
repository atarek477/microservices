package com.ahmed.app.configuration;

import lombok.Getter;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;



@Configuration
@Getter

public class NotificationConfiguration {

    @Value("${broker.exchange}")
    private String internalExchange;

    @Value("${spring.rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${broker.routingKey}")
    private String internalNotificationRoutingkey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(internalExchange);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(Queue notificationQueue, TopicExchange internalTopicExchange) {
        return BindingBuilder.bind(notificationQueue).to(internalTopicExchange).with(internalNotificationRoutingkey);
    }
}
