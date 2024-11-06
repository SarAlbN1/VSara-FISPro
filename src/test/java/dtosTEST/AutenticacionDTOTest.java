package dtosTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.teamconect.dtos.AutenticacionDTO;

public class AutenticacionDTOTest {

    
    @Test
    public void testConstructorAndGetters() {
        AutenticacionDTO authDTO = new AutenticacionDTO("email@example.com", "password123", "123456", "1234567890");

        assertEquals("email@example.com", authDTO.getEmail());
        assertEquals("password123", authDTO.getPassword());
        assertEquals("123456", authDTO.getVerificationCode());
        assertEquals("1234567890", authDTO.getPhoneNumber());
    }

    @Test
    public void testSetters() {
        AutenticacionDTO authDTO = new AutenticacionDTO();

        authDTO.setEmail("email@example.com");
        authDTO.setPassword("password123");
        authDTO.setVerificationCode("123456");
        authDTO.setPhoneNumber("1234567890");

        assertEquals("email@example.com", authDTO.getEmail());
        assertEquals("password123", authDTO.getPassword());
        assertEquals("123456", authDTO.getVerificationCode());
        assertEquals("1234567890", authDTO.getPhoneNumber());
    }
}
