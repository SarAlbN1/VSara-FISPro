package repositoriesTEST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teamconect.models.Task;
import com.teamconect.repositories.TaskRepository;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testFindByAssignedUserId() {
        Task task1 = new Task();
        task1.setAssignedUserId(1L);
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setAssignedUserId(1L);
        task2.setTitle("Task 2");

        taskRepository.save(task1);
        taskRepository.save(task2);

        List<Task> tasks = taskRepository.findByAssignedUserId(1L);
        assertEquals(2, tasks.size());
    }

    @Test
    public void testFindByDepartment() {
        Task task = new Task();
        task.setDepartment(2L);
        task.setTitle("Task for department 2");

        taskRepository.save(task);

        List<Task> tasks = taskRepository.findByDepartment(2L);
        assertEquals(1, tasks.size());
    }

    @Test
    public void testFindByArea() {
        Task task = new Task();
        task.setArea(3L);
        task.setTitle("Task for area 3");

        taskRepository.save(task);

        List<Task> tasks = taskRepository.findByArea(3L);
        assertEquals(1, tasks.size());
    }
}
