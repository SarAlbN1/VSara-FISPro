package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamconect.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
}
