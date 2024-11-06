package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamconect.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByAssignedUserId(Long userId);
    List<Task> findByDepartment(Long departmentId);
    List<Task> findByArea(Long areaId);
}
