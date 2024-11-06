package dtosTEST;

public class TaskDTO {
    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private Long taskAssignedUserId;
    private String taskStatus;

    // Constructor vacío
    public TaskDTO() {}

    // Constructor con parámetros
    public TaskDTO(Long taskId, String title, String description, Long assignedUserId, String status) {
        this.taskId = taskId;
        this.taskTitle = title;
        this.taskDescription = description;
        this.taskAssignedUserId = assignedUserId;
        this.taskStatus = status;
    }

    // Getters y Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return taskTitle;
    }

    public void setTitle(String title) {
        this.taskTitle = title;
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String description) {
        this.taskDescription = description;
    }

    public Long getAssignedUserId() {
        return taskAssignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.taskAssignedUserId = assignedUserId;
    }

    public String getStatus() {
        return taskStatus;
    }

    public void setStatus(String status) {
        this.taskStatus = status;
    }
}
