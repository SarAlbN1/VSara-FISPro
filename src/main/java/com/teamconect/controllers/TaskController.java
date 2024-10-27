package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignTask(@RequestBody Task task) {
        taskService.assignTask(task);
        return new ResponseEntity<>("Tarea asignada con éxito", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return task != null ? new ResponseEntity<>(task, HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  

}
