package com.teamconect.dtos;

public class TaskDTO {
    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private Long assignedUserId;
    private String taskStatus;

    // Constructor vacío
    public TaskDTO() {}

    // Constructor con parámetros
    public TaskDTO(Long taskId, String title, String description, Long assignedUserId, String status) {
        this.taskId = taskId;
        this.taskTitle = title;
        this.taskDescription = description;
        this.assignedUserId = assignedUserId;
        this.taskStatus = status;
    }

    // Getters y Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
