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

    public List<Task> getTasksByUser(String userId) {
        return taskRepository.findByAssignedUser(userId);
    }

    public List<Task> getTasksByDepartment(String departmentId) {
        return taskRepository.findByDepartment(departmentId);
    }

    public List<Task> getTasksByDepartment(String departmentId) {
        return taskRepository.findByDepartment(departmentId);
    }

    public List<Task> getTasksByArea(String areaId) {
        return taskRepository.findByArea(areaId);
    }
    

}
