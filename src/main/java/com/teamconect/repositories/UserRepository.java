package com.teamconect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Métodos personalizados de consulta (si es necesario)
}
