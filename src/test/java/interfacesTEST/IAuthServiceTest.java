package interfacesTEST;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.teamconect.services.interfaces.IAuthService;

public class IAuthServiceTest {

    private final IAuthService authService = Mockito.mock(IAuthService.class);

    @Test
    public void testSendVerificationCode() {
        String phoneNumber = "123456789";
        Mockito.when(authService.sendVerificationCode(phoneNumber)).thenReturn(true);

        boolean result = authService.sendVerificationCode(phoneNumber);
        assertTrue(result);
    }

    @Test
    public void testVerifyCode() {
        String phoneNumber = "123456789";
        String code = "1234";
        Mockito.when(authService.verifyCode(phoneNumber, code)).thenReturn(true);

        boolean result = authService.verifyCode(phoneNumber, code);
        assertTrue(result);
    }

    @Test
    public void testAuthenticateUser() {
        String email = "user@example.com";
        String password = "password123";
        String verificationCode = "1234";
        Mockito.when(authService.authenticateUser(email, password, verificationCode)).thenReturn(true);

        boolean result = authService.authenticateUser(email, password, verificationCode);
        assertTrue(result);
    }
}
