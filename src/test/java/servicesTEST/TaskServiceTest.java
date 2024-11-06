package servicesTEST;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamconect.models.Task;
import com.teamconect.repositories.TaskRepository;
import com.teamconect.services.TaskService;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignTask() {
        Task task = new Task();
        task.setTitle("New Task");

        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.assignTask(task);
        assertEquals("New Task", result.getTitle());
    }

    @Test
    public void testUpdateTaskStatus() {
        Long taskId = 1L;
        String newStatus = "Completed";
        Task task = new Task();
        task.setStatus("Pending");

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.updateTaskStatus(taskId, newStatus);
        assertEquals(newStatus, result.getStatus());
    }

    @Test
    public void testGetTasksByUser() {
        Long userId = 1L;
        Task task = new Task();
        task.setAssignedUserId(userId);

        when(taskRepository.findByAssignedUserId(userId)).thenReturn(List.of(task));

        List<Task> result = taskService.getTasksByUser(userId);
        assertEquals(1, result.size());
    }
}
