package dtosTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.teamconect.dtos.UserDTO;

public class UserDTOTest {

    @Test
    public void testConstructorAndGetters() {
        UserDTO userDTO = new UserDTO(1L, "UserName", "user@example.com", "password123", "123456", 1234567890, "Admin", "IT");

        assertEquals(1L, userDTO.getUserId());
        assertEquals("UserName", userDTO.getUserName());
        assertEquals("user@example.com", userDTO.getUserEmail());
        assertEquals("password123", userDTO.getUserPassword());
        assertEquals("123456", userDTO.getUserVerificationCode());
        assertEquals(1234567890, userDTO.getUserPhoneNumber());
        assertEquals("Admin", userDTO.getUserRole());
        assertEquals("IT", userDTO.getUserDepartment());
    }

    @Test
    public void testSetters() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(1L);
        userDTO.setUsername("UserName");
        userDTO.setUserEmail("user@example.com");
        userDTO.setPassword("password123");
        userDTO.setUserVerificationCode("123456");
        userDTO.setUserPhoneNumber(1234567890);
        userDTO.setUserRole("Admin");
        userDTO.setUserDepartment("IT");

        assertEquals(1L, userDTO.getUserId());
        assertEquals("UserName", userDTO.getUserName());
        assertEquals("user@example.com", userDTO.getUserEmail());
        assertEquals("password123", userDTO.getUserPassword());
        assertEquals("123456", userDTO.getUserVerificationCode());
        assertEquals(1234567890, userDTO.getUserPhoneNumber());
        assertEquals("Admin", userDTO.getUserRole());
        assertEquals("IT", userDTO.getUserDepartment());
    }
}
