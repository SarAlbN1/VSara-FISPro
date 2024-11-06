package com.teamconect.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long assignedUserId;  // Identificador de usuario asignado
    private String status;
    private Long department;  // Identificador de departamento
    private Long area;  // Identificador de área

    public Task(String taskTitle, String taskDescription, Long assignedUserId, String taskStatus) {
    this.title = taskTitle;
    this.description = taskDescription;
    this.assignedUserId = assignedUserId;
    this.status = taskStatus;
    }

    public Task(String designModule, String createDesignForModule, long l, String pending, long l1, long l2) {
        this.title = designModule;
        this.description = createDesignForModule;
        this.assignedUserId = l;
        this.status = pending;
        this.department = l1;
        this.area = l2;
    }
}
