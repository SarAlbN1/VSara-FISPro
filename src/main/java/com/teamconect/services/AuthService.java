package com.teamconect.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private String generatedCode;

    // Genera un código de verificación de 6 dígitos
    public String generateVerificationCode() {
        generatedCode = String.valueOf(100000 + new Random().nextInt(900000));
        return generatedCode;
    }

    public boolean authenticateUser(String inputCode) {
        return generatedCode != null && generatedCode.equals(inputCode);
    }
}
