package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String loginUser(@RequestBody AutenticacionDTO authDTO) {
        boolean authenticated = authService.authenticateUser(authDTO);
        return authenticated ? "Inicio de sesión exitoso" : "Error en autenticación";
    }

    @PostMapping("/send-code")
    public String sendVerificationCode(@RequestParam String phoneNumber) {
        authService.generateVerificationCode();
        authService.sendVerificationCode(phoneNumber);
        return "Código de verificación enviado";
    }
}
