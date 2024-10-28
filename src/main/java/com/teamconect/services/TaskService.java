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

    public Task updateTaskStatus(String taskId, String status) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setStatus(status);
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    public List<Task> getTasksByUser(String userId) {
        return taskRepository.findByAssignedUser(userId);
    }

    public List<Task> getTasksByDepartment(String departmentId) {
        return taskRepository.findByDepartment(departmentId);
    }

    public List<Task> getTasksByArea(String areaId) {
        return taskRepository.findByArea(areaId);
    }
}
