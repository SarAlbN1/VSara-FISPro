package com.teamconect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.models.Task;
import com.teamconect.models.User;
import com.teamconect.repositories.TaskRepository;
import com.teamconect.repositories.UserRepository;

@Service
public class TaskAssignmentService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public Task assignTaskToUser(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (task != null && user != null) {
            task.setAssignedUserId(userId);
            Task assignedTask = taskRepository.save(task);

            // Crear una notificación para el usuario asignado
            String message = "Se te ha asignado una nueva tarea: " + task.getTitle();
            notificationService.createNotification(message, userId);

            return assignedTask;
        }
        return null; // Retornar null si el task o user no existen
    }
}
