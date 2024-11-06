package com.teamconect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User assignRoleAndDepartment(Long userId, String role, String department) {
        return userRepository.findById(userId).map(user -> {
            user.setRol(role);
            user.setDepartamento(department);
            return userRepository.save(user);
        }).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
