package com.teamconect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);  // Método de búsqueda por correo
}
