package com.teamconect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.models.Notification;
import com.teamconect.models.User;
import com.teamconect.repositories.NotificationRepository;
import com.teamconect.repositories.UserRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Notification createNotification(String message, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null; // Maneja el error de usuario no encontrado
        }

        Notification notification = new Notification(message, user);
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public boolean markNotificationAsRead(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .map(notification -> {
                    notification.setRead(true);
                    notificationRepository.save(notification);
                    return true;
                })
                .orElse(false);
    }
}
