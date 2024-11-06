package repositoriesTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teamconect.models.User;
import com.teamconect.repositories.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        User user = new User();
        user.setEmail("user@example.com");
        user.setPassword("password123");

        userRepository.save(user);

        User foundUser = userRepository.findByEmail("user@example.com");
        assertNotNull(foundUser);
        assertEquals("user@example.com", foundUser.getEmail());
    }
}
