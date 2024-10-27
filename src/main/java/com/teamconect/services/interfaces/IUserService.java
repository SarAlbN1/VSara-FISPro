// IUserService.java
package com.teamconect.services.interfaces;

import com.teamconect.dtos.UserDTO;

public interface IUserService {
    void registerUser(UserDTO userDTO);
    UserDTO getUserById(String userId);
    void assignAttributes(String userId, String role, String department, String area, String lineOfCommand);
}
