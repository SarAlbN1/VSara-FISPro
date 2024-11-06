package com.teamconect.dtos;

public class TaskDTO {
    private String Tasktitle;
    private String Taskdescription;
    private String TaskassignedUserId;
    private String Taskstatus;

    // Constructor vacío
    public TaskDTO() {}

    // Constructor con parámetros
    public TaskDTO(String title, String description, String assignedUserId, String status) {
        this.Tasktitle = title;
        this.Taskdescription = description;
        this.TaskassignedUserId = assignedUserId;
        this.Taskstatus = status;
    }

    // Getters y Setters
    public String getTitle() {
        return Tasktitle;
    }

    public void setTitle(String title) {
        this.Tasktitle = title;
    }

    public String getDescription() {
        return Taskdescription;
    }

    public void setDescription(String description) {
        this.Taskdescription = description;
    }

    public String getAssignedUserId() {
        return TaskassignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.TaskassignedUserId = assignedUserId;
    }

    public String getStatus() {
        return Taskstatus;
    }

    public void setStatus(String status) {
        this.Taskstatus = status;
    }
}
