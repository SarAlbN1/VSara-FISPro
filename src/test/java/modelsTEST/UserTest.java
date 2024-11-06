package modelsTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.teamconect.models.User;


public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("Alice", "alice@example.com", "securePassword", 123456789);

        assertEquals("Alice", user.getName());
        assertEquals("alice@example.com", user.getEmail());
        assertEquals("securePassword", user.getPassword());
        assertEquals(123456789, user.getPhoneNumber());
    }

    @Test
    public void testUserRoleAssignment() {
        User user = new User("Alice", "alice@example.com", "securePassword", 123456789);

        user.setRol("Manager");
        assertEquals("Manager", user.getRol());
    }

    @Test
    public void testUserDepartmentAssignment() {
        User user = new User("Alice", "alice@example.com", "securePassword", 123456789);

        user.setDepartamento("Finance");
        assertEquals("Finance", user.getDepartamento());
    }

    @Test
    public void testUserEmailUpdate() {
        User user = new User("Alice", "alice@example.com", "securePassword", 123456789);

        user.setEmail("newalice@example.com");
        assertEquals("newalice@example.com", user.getEmail());
    }
}