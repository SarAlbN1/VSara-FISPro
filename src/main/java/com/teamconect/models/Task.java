package com.teamconect.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private String assignedUserId;
    private String status; // Estado de la tarea: "pendiente", "en progreso", "completado"

    // Constructor vacío
    public Task() {}

    // Constructor con parámetros
    public Task(String title, String description, String assignedUserId, String status) {
        this.title = title;
        this.description = description;
        this.assignedUserId = assignedUserId;
        this.status = status;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAssignedUserId() { return assignedUserId; }
    public void setAssignedUserId(String assignedUserId) { this.assignedUserId = assignedUserId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
