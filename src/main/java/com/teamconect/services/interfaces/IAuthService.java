// IAuthService.java
package com.teamconect.services.interfaces;

public interface IAuthService {
    boolean sendVerificationCode(String phone);
    boolean verifyCode(String phone, String code);
}
