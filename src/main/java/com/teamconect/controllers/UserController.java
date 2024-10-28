package com.teamconect.controllers;

import com.teamconect.dtos.UsuarioRolDTO;
import com.teamconect.models.User;
import com.teamconect.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
        return userService.registerUser(user);
    }

    @PostMapping("/assign-role-department")
    public User assignRoleAndDepartment(@RequestBody UsuarioRolDTO usuarioRolDTO) {
        return userService.assignRoleAndDepartment(usuarioRolDTO);
    }
}
