package servicesTEST;

import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;
import com.teamconect.services.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.MockedStatic;
import org.springframework.boot.test.context.SpringBootTest;
import com.twilio.Twilio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateCredentials_Success() {
        AutenticacionDTO authDTO = new AutenticacionDTO("test@example.com", "password123", null, null);
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");

        when(userRepository.findByEmail(authDTO.getEmail())).thenReturn(user);

        boolean result = authService.validateCredentials(authDTO);

        assertTrue(result);
        verify(userRepository, times(1)).findByEmail(authDTO.getEmail());
    }

    @Test
    public void testSendVerificationCode_Success() {
        String phoneNumber = "+1234567890";
        User user = new User();
        user.setPhoneNumber(Integer.parseInt(phoneNumber.replaceAll("[^\\d]", ""))); // Casting del número a int sin caracteres especiales

        // Usar un método protegido o un setter en `AuthService` si se necesita acceder a authenticatedUser
        authService.setAuthenticatedUser(user);

        try (MockedStatic<Twilio> mockedTwilio = mockStatic(Twilio.class)) {
            boolean result = authService.sendVerificationCode(phoneNumber);
            assertTrue(result);
            mockedTwilio.verify(() -> Twilio.init(anyString(), anyString()), times(1));
        }
    }

    @Test
    public void testVerifyCode_Success() {
        String code = "123456";
        
        // Usar un método protegido o un setter en `AuthService` si se necesita acceso a generatedCode
        authService.setGeneratedCode(code);

        boolean result = authService.verifyCode(code);

        assertTrue(result);
    }

    @Test
    public void testGetAuthenticatedUserRole() {
        User user = new User();
        user.setRol("Admin");
        
        // Usar un método protegido o un setter en `AuthService` si se necesita acceder a authenticatedUser
        authService.setAuthenticatedUser(user);

        String role = authService.getAuthenticatedUserRole();

        assertEquals("Admin", role);
    }
}
