package controllersTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.controllers.AuthController;
import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.services.AuthService;

public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginUser_ValidUser_ReturnsAuthenticated() {
        AutenticacionDTO authDTO = new AutenticacionDTO();
        when(authService.validateCredentials(authDTO)).thenReturn(true);

        String result = authController.loginUser(authDTO);
        assertEquals("authenticated", result);
    }

    @Test
    void loginUser_InvalidUser_ReturnsError() {
        AutenticacionDTO authDTO = new AutenticacionDTO();
        when(authService.validateCredentials(authDTO)).thenReturn(false);

        String result = authController.loginUser(authDTO);
        assertEquals("error", result);
    }

    @Test
    void sendVerificationCode_ValidPhone_ReturnsCodeSent() {
        when(authService.sendVerificationCode(anyString())).thenReturn(true);

        String result = authController.sendVerificationCode("1234567890");
        assertEquals("code_sent", result);
    }

    @Test
    void sendVerificationCode_InvalidPhone_ReturnsPhoneMismatch() {
        when(authService.sendVerificationCode(anyString())).thenReturn(false);

        String result = authController.sendVerificationCode("0987654321");
        assertEquals("phone_mismatch", result);
    }

    @Test
    void verifyCode_ValidCode_ReturnsRole() {
        when(authService.verifyCode(anyString())).thenReturn(true);
        when(authService.getAuthenticatedUserRole()).thenReturn("Admin");

        String result = authController.verifyCode("123456");
        assertEquals("Admin", result);
    }

    @Test
    void verifyCode_InvalidCode_ReturnsError() {
        when(authService.verifyCode(anyString())).thenReturn(false);

        String result = authController.verifyCode("654321");
        assertEquals("error", result);
    }
}
