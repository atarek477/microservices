package com.ahmed.app.service;


import com.ahmed.app.model.Notification;
import com.ahmed.app.notification.NotificationRequest;
import com.ahmed.app.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {




        notificationRepository.save(Notification.builder()
                        .customerId(notificationRequest.customerId())
                        .email(notificationRequest.email())
                        .sender("ahmed")
                        .message(notificationRequest.message())
                        .createdAt(LocalDateTime.now())
                        .build());
    }
}
