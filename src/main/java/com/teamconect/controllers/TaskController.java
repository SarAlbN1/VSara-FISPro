package com.teamconect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-department/{department}")
    public ResponseEntity<List<Task>> getTasksByDepartment(@PathVariable Long departmentID) {
        List<Task> tasks = taskService.getTasksByDepartment(departmentID);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-area/{area}")
    public ResponseEntity<List<Task>> getTasksByArea(@PathVariable Long area) {
        List<Task> tasks = taskService.getTasksByArea(area);
        return ResponseEntity.ok(tasks);
    }
}
