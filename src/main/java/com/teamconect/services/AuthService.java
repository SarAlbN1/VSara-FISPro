package com.teamconect.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private String generatedCode;
    private User authenticatedUser;

    private final String TWILIO_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private final String TWILIO_AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    private final String TWILIO_PHONE_NUMBER = System.getenv("TWILIO_PHONE_NUMBER");

    public boolean validateCredentials(AutenticacionDTO authDTO) {
        User user = userRepository.findByEmail(authDTO.getEmail());
        if (user != null && user.getPassword().equals(authDTO.getPassword())) {
            authenticatedUser = user;
            return true;
        }
        return false;
    }

    public boolean sendVerificationCode(String phoneNumber) {
        if (authenticatedUser != null && String.valueOf(authenticatedUser.getPhoneNumber()).equals(phoneNumber)) {
            generatedCode = String.format("%04d", new Random().nextInt(10000));
            Twilio.init(TWILIO_SID, TWILIO_AUTH_TOKEN);
            try {
                Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber(TWILIO_PHONE_NUMBER),
                        "Su código de verificación es: " + generatedCode
                ).create();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean verifyCode(String code) {
        return generatedCode != null && generatedCode.equals(code);
    }

    public String getAuthenticatedUserRole() {
        return authenticatedUser != null ? authenticatedUser.getRol() : null;
    }

    public void setAuthenticatedUser(User user) {
        this.authenticatedUser = user;
    }

    public void setGeneratedCode(String code) {
        this.generatedCode = code;
    }
}
