// TaskService.java
package com.teamconect.services;

import com.teamconect.dtos.TaskDTO;
import com.teamconect.models.Task;
import com.teamconect.repositories.TaskRepository;
import com.teamconect.services.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void assignTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setAssignedUserId(taskDTO.getAssignedUserId());
        task.setDepartmentId(taskDTO.getDepartmentId());
        task.setAreaId(taskDTO.getAreaId());
        taskRepository.save(task);
    }

    @Override
    public TaskDTO getTaskById(String taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            return mapToDTO(task);
        }
        return null;
    }

    @Override
    public List<TaskDTO> getTasksByUserId(String userId) {
        List<Task> tasks = taskRepository.findAllByAssignedUserId(userId);
        return tasks.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private TaskDTO mapToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setAssignedUserId(task.getAssignedUserId());
        dto.setDepartmentId(task.getDepartmentId());
        dto.setAreaId(task.getAreaId());
        return dto;
    }
}
