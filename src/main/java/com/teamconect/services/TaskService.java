package com.teamconect.services;

import java.util.List;
import java.util.Optional;

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
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(status);
            return taskRepository.save(task);
        }
        return null;
    }

    // Obtiene las tareas por usuario
    public List<Task> getTasksByUser(String userId) {
        return taskRepository.findByAssignedUser(userId);
    }

    // Obtiene las tareas por departamento
    public List<Task> getTasksByDepartment(String departmentId) {
        return taskRepository.findByDepartment(departmentId);
    }

    // Obtiene las tareas por área
    public List<Task> getTasksByArea(String areaId) {
        return taskRepository.findByArea(areaId);
    }
}
