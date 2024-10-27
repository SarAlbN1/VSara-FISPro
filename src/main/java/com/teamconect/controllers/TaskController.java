package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/assign")
    public Task assignTask(@RequestBody Task task) {
        return taskService.assignTask(task);
    }

    @PutMapping("/update-status/{taskId}")
    public Task updateTaskStatus(@PathVariable String taskId, @RequestParam String status) {
        return taskService.updateTaskStatus(taskId, status);
    }
}
