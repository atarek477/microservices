package com.ahmed.app.controller;


import com.ahmed.app.notification.NotificationRequest;
import com.ahmed.app.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){

        log.info("new notification {}", notificationRequest);
        notificationService.send(notificationRequest);

    }


}
