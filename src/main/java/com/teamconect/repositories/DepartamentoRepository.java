package com.teamconect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.Departamento;

public interface DepartamentoRepository extends MongoRepository<Departamento, String> {}
