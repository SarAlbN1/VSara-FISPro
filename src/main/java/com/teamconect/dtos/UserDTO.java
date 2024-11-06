package com.teamconect.dtos;

public class UserDTO {
    private Long UserId;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private String UserVerificationCode;
    private int UserPhoneNumber;
    private String UserRole;
    private String UserDepartment;

    // Empty Constructor
    public UserDTO() {}

    // Constructor with parameters
    public UserDTO(Long id, String username, String email, String password, String verificationCode, int phoneNumber, String role, String department) {
        this.UserId = id;
        this.UserName = username;
        this.UserEmail = email;
        this.UserPassword = password;
        this.UserVerificationCode = verificationCode;
        this.UserPhoneNumber = phoneNumber;
        this.UserRole = role;
        this.UserDepartment = department;
    }

    // Getters and Setters
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        this.UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUsername(String username) {
        this.UserName = username;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String email) {
        this.UserEmail = email;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setPassword(String password) {
        this.UserPassword = password;
    }

    public String getUserVerificationCode() {
        return UserVerificationCode;
    }

    public void setUserVerificationCode(String verificationCode) {
        this.UserVerificationCode = verificationCode;
    }

    public int getUserPhoneNumber() {
        return UserPhoneNumber;
    }

    public void setUserPhoneNumber(int phoneNumber) {
        this.UserPhoneNumber = phoneNumber;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String role) {
        this.UserRole = role;
    }

    public String getUserDepartment() {
        return UserDepartment;
    }

    public void setUserDepartment(String department) {
        this.UserDepartment = department;
    }
}
