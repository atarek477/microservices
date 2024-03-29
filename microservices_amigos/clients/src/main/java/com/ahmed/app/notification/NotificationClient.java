package com.ahmed.app.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);


}
