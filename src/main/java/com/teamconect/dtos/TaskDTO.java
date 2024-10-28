package com.teamconect.dtos;

public class TaskDTO {
    private String title;
    private String description;
    private String assignedUserId;
    private String status;

    public TaskDTO() {}

    public TaskDTO(String title, String description, String assignedUserId, String status) {
        this.title = title;
        this.description = description;
        this.assignedUserId = assignedUserId;
        this.status = status;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAssignedUserId() { return assignedUserId; }
    public void setAssignedUserId(String assignedUserId) { this.assignedUserId = assignedUserId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
