package com.teamconect.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private String generatedCode;

    // Configuración de Twilio
    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number}")
    private String twilioPhoneNumber;

    // Inicializa Twilio con las credenciales de la cuenta
    public void initializeTwilio() {
        Twilio.init(accountSid, authToken);
    }

    // Genera un código de verificación de 6 dígitos
    public String generateVerificationCode() {
        generatedCode = String.valueOf(100000 + new Random().nextInt(900000));
        return generatedCode;
    }

    // Envía el código de verificación por SMS usando Twilio
    public void sendVerificationCode(String userPhoneNumber) {
        initializeTwilio();  // Inicializa Twilio solo cuando se va a enviar el SMS

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(userPhoneNumber),  // Número del destinatario
                new com.twilio.type.PhoneNumber(twilioPhoneNumber), // Número de Twilio desde el cual se envía
                "Tu código de verificación es: " + generatedCode)    // Contenido del mensaje
            .create();

        System.out.println("Código de verificación enviado. SID del mensaje: " + message.getSid());
    }

    // Método de autenticación que verifica el código de usuario
    public boolean authenticateUser(AutenticacionDTO authDTO) {
        User user = userRepository.findByEmail(authDTO.getEmail());
        if (user != null && user.getPassword().equals(authDTO.getPassword())) {
            return authDTO.getVerificationCode().equals(generatedCode);
        }
        return false;
    }
}
