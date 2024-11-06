package servicesTEST;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.models.Task;
import com.teamconect.repositories.TaskRepository;
import com.teamconect.services.TaskService;

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
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testUpdateTaskStatus() {
        Long taskId = 1L;
        String newStatus = "Completed";
        Task task = new Task();
        task.setStatus("Pending");

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        boolean result = taskService.updateTaskStatus(taskId, newStatus);
        assertTrue(result); // Verifica que el estado fue actualizado exitosamente
        assertEquals(newStatus, task.getStatus()); // Verifica que el estado se actualizó en el objeto
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testGetTasksByUser() {
        Long userId = 1L;
        Task task1 = new Task();
        task1.setAssignedUserId(userId);
        task1.setTitle("User Task 1");

        when(taskRepository.findByAssignedUserId(userId)).thenReturn(List.of(task1));

        List<Task> result = taskService.getTasksByUser(userId);
        assertEquals(1, result.size());
        assertEquals("User Task 1", result.get(0).getTitle());
        verify(taskRepository, times(1)).findByAssignedUserId(userId);
    }

    @Test
    public void testGetTasksByDepartment() {
        Long departmentId = 1L;
        Task task1 = new Task();
        task1.setDepartment(departmentId);
        task1.setTitle("Department Task 1");

        when(taskRepository.findByDepartment(departmentId)).thenReturn(List.of(task1));

        List<Task> result = taskService.getTasksByDepartment(departmentId);
        assertEquals(1, result.size());
        assertEquals("Department Task 1", result.get(0).getTitle());
        verify(taskRepository, times(1)).findByDepartment(departmentId);
    }

    @Test
    public void testGetTasksByArea() {
        Long areaId = 1L;
        Task task1 = new Task();
        task1.setArea(areaId);
        task1.setTitle("Area Task 1");

        when(taskRepository.findByArea(areaId)).thenReturn(List.of(task1));

        List<Task> result = taskService.getTasksByArea(areaId);
        assertEquals(1, result.size());
        assertEquals("Area Task 1", result.get(0).getTitle());
        verify(taskRepository, times(1)).findByArea(areaId);
    }
}
