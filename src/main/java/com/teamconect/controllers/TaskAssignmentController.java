package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teamconect.dtos.TaskDTO;
import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

@RestController
@RequestMapping("/api/task-assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/assign")
    public ResponseEntity<Task> assignTask(@RequestBody TaskDTO taskDTO) {
        // Convertimos TaskDTO en Task para asignación
        Task task = new Task(
            taskDTO.getTaskTitle(),
            taskDTO.getTaskDescription(),
            taskDTO.getAssignedUserId(),
            taskDTO.getTaskStatus()
        );

        Task assignedTask = taskService.assignTask(task);
        return ResponseEntity.ok(assignedTask);
    }
}
