package com.ahmed.app.notification;

import java.time.LocalDateTime;

public record NotificationRequest(String  message,

                                  String email,

                                  Integer customerId) {
}
