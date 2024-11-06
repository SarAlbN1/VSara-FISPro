package repositoriesTEST;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teamconect.models.Rol;
import com.teamconect.repositories.RolRepository;

@DataJpaTest
public class RolRepositoryTest {

    @Autowired
    private RolRepository rolRepository;

    @Test
    public void testSaveRol() {
        Rol rol = new Rol();
        rol.setNombre("Admin");
        Rol savedRol = rolRepository.save(rol);

        assertNotNull(savedRol.getId());
    }
}
