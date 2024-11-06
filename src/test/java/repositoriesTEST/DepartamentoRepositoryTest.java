package repositoriesTEST;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teamconect.models.Departamento;
import com.teamconect.repositories.DepartamentoRepository;

@DataJpaTest
public class DepartamentoRepositoryTest {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    public void testSaveDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNombre("IT");
        Departamento savedDepartamento = departamentoRepository.save(departamento);

        assertNotNull(savedDepartamento.getId());
    }
}
