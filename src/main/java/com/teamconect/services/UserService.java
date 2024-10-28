package com.teamconect.services;

import com.teamconect.dtos.UsuarioRolDTO;
import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User assignRoleAndDepartment(UsuarioRolDTO usuarioRolDTO) {
        Optional<User> userOptional = userRepository.findById(usuarioRolDTO.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setRolId(usuarioRolDTO.getRolId());
            user.setDepartamentoId(usuarioRolDTO.getDepartamentoId());
            return userRepository.save(user);
        }
        return null;
    }
}
