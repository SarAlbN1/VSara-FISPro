package com.teamconect.dtos;

public class AutenticacionDTO {
    private String email;
    private String password;
    private String verificationCode;
    private String phoneNumber;

    public AutenticacionDTO() {}

    public AutenticacionDTO(String email, String password, String verificationCode, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
