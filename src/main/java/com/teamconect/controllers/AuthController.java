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
        boolean isUserValid = authService.validateCredentials(authDTO);
        return isUserValid ? "authenticated" : "error";
    }

    @PostMapping("/send-code")
    public String sendVerificationCode(@RequestParam String phoneNumber) {
        boolean isCodeSent = authService.sendVerificationCode(phoneNumber);
        return isCodeSent ? "code_sent" : "phone_mismatch";
    }

    @PostMapping("/verify-code")
    public String verifyCode(@RequestParam String code) {
        boolean isCodeValid = authService.verifyCode(code);
        if (isCodeValid) {
            return authService.getAuthenticatedUserRole();
        }
        return "error";
    }
}
