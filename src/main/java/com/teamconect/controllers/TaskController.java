package com.teamconect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable String userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-department/{departmentId}")
    public ResponseEntity<List<Task>> getTasksByDepartment(@PathVariable String departmentId) {
        List<Task> tasks = taskService.getTasksByDepartment(departmentId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-area/{areaId}")
    public ResponseEntity<List<Task>> getTasksByArea(@PathVariable String areaId) {
        List<Task> tasks = taskService.getTasksByArea(areaId);
        return ResponseEntity.ok(tasks);
    }
}

}
