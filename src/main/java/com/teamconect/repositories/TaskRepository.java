package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByAssignedUser(String userId);
    List<Task> findByDepartment(String departmentId);
    List<Task> findByArea(String areaId);
}
