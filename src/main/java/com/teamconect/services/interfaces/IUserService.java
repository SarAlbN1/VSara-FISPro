package com.teamconect.services.interfaces;

import com.teamconect.dtos.UserDTO;

public interface IUserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(String userId);
}
