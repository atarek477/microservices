package com.ahmed.app;


import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQProducer {
    private final AmqpTemplate amqpTemplate;
    public void publish(Object payload , String exchange , String routingKey){

        try {
            // Validate parameters
            if (exchange == null || exchange.isEmpty()) {
                throw new IllegalArgumentException("Exchange name cannot be null or empty");
            }
            if (routingKey == null || routingKey.isEmpty()) {
                throw new IllegalArgumentException("Routing key cannot be null or empty");
            }

            // Publish the message
            amqpTemplate.convertAndSend(exchange, routingKey, payload);
        } catch (AmqpException ex) {
            // Handle AMQP exceptions (e.g., communication errors with RabbitMQ)
            // Log the error or handle it appropriately based on your application's requirements
            ex.printStackTrace(); // Example: print stack trace for now
        } catch (RuntimeException ex) {
            // Handle other runtime exceptions
            // Log the error or handle it appropriately based on your application's requirements
            ex.printStackTrace(); // Example: print stack trace for now
        }

    }


}
