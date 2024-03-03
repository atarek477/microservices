package com.ahmed.app.rabbitmq;


import com.ahmed.app.notification.NotificationRequest;
import com.ahmed.app.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {

        log.info("consumed from queue {}", notificationRequest);
        notificationService.send(notificationRequest);
    }


}
