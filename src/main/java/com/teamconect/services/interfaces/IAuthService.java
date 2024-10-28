package com.teamconect.services.interfaces;

public interface IAuthService {
    boolean sendVerificationCode(String phoneNumber);
    boolean verifyCode(String phoneNumber, String code);
    boolean authenticateUser(String email, String password, String verificationCode);
}
