package controllersTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

import com.teamconect.controllers.AuthController;
import com.teamconect.dtos.AutenticacionDTO;
import com.teamconect.services.AuthService;

public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @Test
    void loginUser_ValidUser_ReturnsAuthenticated() {
        AutenticacionDTO authDTO = new AutenticacionDTO();
        when(authService.validateCredentials(authDTO)).thenReturn(true);

        ResponseEntity<String> result = authController.loginUser(authDTO);
        assertEquals("authenticated", result.getBody());
    }

    @Test
    void loginUser_InvalidUser_ReturnsError() {
        AutenticacionDTO authDTO = new AutenticacionDTO();
        when(authService.validateCredentials(authDTO)).thenReturn(false);

        ResponseEntity<String> result = authController.loginUser(authDTO);
        assertEquals("error", result.getBody());
    }

    @Test
    void sendVerificationCode_ValidPhone_ReturnsCodeSent() {
        when(authService.sendVerificationCode(anyString())).thenReturn(true);

        ResponseEntity<String> result = authController.sendVerificationCode("1234567890");
        assertEquals("code_sent", result.getBody());
    }

    @Test
    void sendVerificationCode_InvalidPhone_ReturnsPhoneMismatch() {
        when(authService.sendVerificationCode(anyString())).thenReturn(false);

        ResponseEntity<String> result = authController.sendVerificationCode("0987654321");
        assertEquals("phone_mismatch", result.getBody());
    }}

