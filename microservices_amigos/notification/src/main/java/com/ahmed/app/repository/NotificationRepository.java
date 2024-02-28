package com.ahmed.app.repository;

import com.ahmed.app.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
