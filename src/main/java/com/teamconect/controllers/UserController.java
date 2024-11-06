package com.teamconect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.dtos.UserDTO;
import com.teamconect.models.User;
import com.teamconect.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        User user = new User(
                userDTO.getUserName(),
                userDTO.getUserEmail(),
                userDTO.getUserPassword(),
                userDTO.getUserPhoneNumber()
        );
        return userService.registerUser(user);
    }

    @PostMapping("/assign-role-department")
    public User assignRoleAndDepartment(@RequestBody UserDTO userDTO) {
        return userService.assignRoleAndDepartment(
                userDTO.getUserId(),
                userDTO.getUserRole(),
                userDTO.getUserDepartment()
        );
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update-role-department")
    public User updateUserRoleAndDepartment(@RequestBody UserDTO userDTO) {
        return userService.assignRoleAndDepartment(
                userDTO.getUserId(),
                userDTO.getUserRole(),
                userDTO.getUserDepartment()
        );
    }
}
