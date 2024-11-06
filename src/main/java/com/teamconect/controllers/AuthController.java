package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.models.User;
import com.teamconect.services.AuthService;
import com.teamconect.services.UserService;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AutenticacionDTO authDTO) {
        boolean isUserValid = authService.validateCredentials(authDTO);
        return isUserValid 
            ? ResponseEntity.ok("authenticated") 
            : ResponseEntity.status(401).body("error"); // 401 Unauthorized
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return newUser != null 
            ? ResponseEntity.ok("registration_success") 
            : ResponseEntity.status(400).body("registration_failed"); // 400 Bad Request
    }

    @PostMapping("/send-code")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String phoneNumber) {
        boolean isCodeSent = authService.sendVerificationCode(phoneNumber);
        return isCodeSent 
            ? ResponseEntity.ok("code_sent") 
            : ResponseEntity.status(404).body("phone_mismatch"); // 404 Not Found
    }

    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestParam String code) {
        boolean isCodeValid = authService.verifyCode(code);
        if (isCodeValid) {
            String role = authService.getAuthenticatedUserRole();
            return ResponseEntity.ok(role); // Devuelve el rol si la autenticación es exitosa
        }
        return ResponseEntity.status(401).body("error"); // 401 Unauthorized
    }
}
