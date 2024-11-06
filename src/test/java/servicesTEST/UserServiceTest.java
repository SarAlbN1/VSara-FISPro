package servicesTEST;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;
import com.teamconect.services.UserService;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setName("John Doe");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.registerUser(user);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testAssignRoleAndDepartment() {
        Long userId = 1L;
        String newRole = "Manager";
        String newDepartment = "HR";
        User user = new User();
        user.setRol("Employee");
        user.setDepartamento("Sales");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.assignRoleAndDepartment(userId, newRole, newDepartment);
        assertEquals(newRole, result.getRol());
        assertEquals(newDepartment, result.getDepartamento());
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User();
        user1.setName("John");
        User user2 = new User();
        user2.setName("Jane");

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
    }
}
