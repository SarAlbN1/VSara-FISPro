package interfacesTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.teamconect.dtos.UserDTO;
import com.teamconect.services.interfaces.IUserService;

public class IUserServiceTest {

    private final IUserService userService = Mockito.mock(IUserService.class);

    @Test
    public void testRegisterUser() {
        UserDTO user = new UserDTO(1L, "John", "john@example.com", "password123", "1234", 1234567890, "User", "Dept");
        Mockito.when(userService.registerUser(user)).thenReturn(user);

        UserDTO result = userService.registerUser(user);
        assertNotNull(result);
        assertEquals("John", result.getUserName());
    }

    @Test
    public void testGetUserById() {
        String userId = "1";
        UserDTO user = new UserDTO(1L, "John", "john@example.com", "password123", "1234", 1234567890, "User", "Dept");
        Mockito.when(userService.getUserById(userId)).thenReturn(user);

        UserDTO result = userService.getUserById(userId);
        assertNotNull(result);
        assertEquals("John", result.getUserName());
    }
}
