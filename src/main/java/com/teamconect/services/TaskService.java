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

    public boolean updateTaskStatus(Long taskId, String status) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setStatus(status);
                    taskRepository.save(task);
                    return true;
                })
                .orElse(false);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByAssignedUserId(userId);
    }

    public List<Task> getTasksByDepartment(Long departmentID) {
        return taskRepository.findByDepartment(departmentID);
    }

    public List<Task> getTasksByArea(Long area) {
        return taskRepository.findByArea(area);
    }
}
