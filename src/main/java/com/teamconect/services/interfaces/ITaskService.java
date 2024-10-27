// ITaskService.java
package com.teamconect.services.interfaces;

import java.util.List;

import com.teamconect.dtos.TaskDTO;

public interface ITaskService {
    void assignTask(TaskDTO taskDTO);
    TaskDTO getTaskById(String taskId);
    List<TaskDTO> getTasksByUserId(String userId);
}
