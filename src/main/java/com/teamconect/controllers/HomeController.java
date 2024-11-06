package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teamconect.models.User;
import com.teamconect.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-info")
    public User getAuthenticatedUserInfo() {
        return userService.getAuthenticatedUser();  // Método que implementaremos en `UserService`
    }

    @GetMapping("/department-colleagues")
    public List<User> getColleaguesInDepartment() {
        return userService.getDepartmentColleagues();  // Método que implementaremos en `UserService`
    }
}
