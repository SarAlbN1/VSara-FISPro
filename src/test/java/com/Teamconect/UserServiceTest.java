// UserServiceTest.java
package com.Teamconect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import com.teamconect.dtos.UserDTO;
import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com");

        userService.registerUser(userDTO);

        verify(userRepository, times(1)).save(any(User.class));
    }
}
