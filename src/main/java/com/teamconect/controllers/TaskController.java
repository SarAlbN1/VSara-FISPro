package com.teamconect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    /**
     * Obtener tareas asignadas a un usuario específico.
     * @param userId ID del usuario
     * @return Lista de tareas del usuario
     */
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        return ResponseEntity.ok(tasks);
    }

    /**
     * Obtener tareas asignadas a un departamento específico.
     * @param departmentID ID del departamento
     * @return Lista de tareas del departamento
     */
    @GetMapping("/by-department/{departmentID}")
    public ResponseEntity<List<Task>> getTasksByDepartment(@PathVariable Long departmentID) {
        List<Task> tasks = taskService.getTasksByDepartment(departmentID);
        return ResponseEntity.ok(tasks);
    }

    /**
     * Obtener tareas asignadas a un área específica.
     * @param area ID del área
     * @return Lista de tareas del área
     */
    @GetMapping("/by-area/{area}")
    public ResponseEntity<List<Task>> getTasksByArea(@PathVariable Long area) {
        List<Task> tasks = taskService.getTasksByArea(area);
        return ResponseEntity.ok(tasks);
    }

    /**
     * Actualizar el estado de una tarea.
     * @param taskId ID de la tarea
     * @param status Nuevo estado de la tarea
     * @return Respuesta de éxito o error
     */
    @PutMapping("/update-status/{taskId}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long taskId, @RequestParam String status) {
        boolean isUpdated = taskService.updateTaskStatus(taskId, status);
        return isUpdated ? ResponseEntity.ok("status_updated") : ResponseEntity.status(404).body("task_not_found");
    }

}
