package controllersTEST;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.controllers.UserController;
import com.teamconect.dtos.UserDTO;
import com.teamconect.models.User;
import com.teamconect.services.UserService;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_CreatesUser_ReturnsUser() {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userService.registerUser(any(User.class))).thenReturn(user);

        User result = userController.registerUser(userDTO);
        assertNotNull(result);
    }

    @Test
    void assignRoleAndDepartment_Assigns_ReturnsUser() {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(userService.assignRoleAndDepartment(anyLong(), anyString(), anyString())).thenReturn(user);

        User result = userController.assignRoleAndDepartment(userDTO);
    }}
