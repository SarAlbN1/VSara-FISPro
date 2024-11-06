package com.teamconect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.models.Task;
import com.teamconect.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task assignTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long taskId, String status) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setStatus(status);
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    public List<Task> getTasksByUser(Long userId) {  // Cambiado a String
        return taskRepository.findByAssignedUserId(userId);
    }

    public List<Task> getTasksByDepartment(Long departmentID) {  // Cambiado a String
        return taskRepository.findByDepartment(departmentID);
    }

    public List<Task> getTasksByArea(Long area) {  // Cambiado a String
        return taskRepository.findByArea(area);
    }
}
