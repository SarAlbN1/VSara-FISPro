package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamconect.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByDepartment(String department);
}
