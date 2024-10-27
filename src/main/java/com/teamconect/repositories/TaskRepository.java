package com.teamconect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    // Métodos personalizados de consulta (si es necesario)
}
