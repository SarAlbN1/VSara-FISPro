package com.teamconect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.teamconect.models.Rol;

public interface RolRepository extends MongoRepository<Rol, String> {}
