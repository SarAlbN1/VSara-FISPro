package com.teamconect.services.interfaces;

import java.util.List;

import com.teamconect.dtos.TaskDTO;

public interface ITaskService {
    TaskDTO assignTask(TaskDTO taskDTO);
    TaskDTO updateTaskStatus(String taskId, String status);
    List<TaskDTO> getTasksByUser(String userId);
    List<TaskDTO> getTasksByDepartment(String departmentId);
    List<TaskDTO> getTasksByArea(String areaId);
}
