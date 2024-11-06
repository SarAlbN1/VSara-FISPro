package interfacesTEST;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.teamconect.dtos.TaskDTO;
import com.teamconect.services.interfaces.ITaskService;

public class ITaskServiceTest {

    private final ITaskService taskService = Mockito.mock(ITaskService.class);

    @Test
    public void testAssignTask() {
        TaskDTO task = new TaskDTO("Task1", "Description1", "User1", "Pending");
        Mockito.when(taskService.assignTask(task)).thenReturn(task);

        TaskDTO result = taskService.assignTask(task);
        assertNotNull(result);
        assertEquals("Task1", result.getTitle());
    }

    @Test
    public void testUpdateTaskStatus() {
        String taskId = "1";
        String newStatus = "Completed";
        TaskDTO task = new TaskDTO("Task1", "Description1", "User1", newStatus);
        Mockito.when(taskService.updateTaskStatus(taskId, newStatus)).thenReturn(task);

        TaskDTO result = taskService.updateTaskStatus(taskId, newStatus);
        assertEquals(newStatus, result.getStatus());
    }

    @Test
    public void testGetTasksByUser() {
        String userId = "User1";
        TaskDTO task1 = new TaskDTO("Task1", "Description1", userId, "Pending");
        TaskDTO task2 = new TaskDTO("Task2", "Description2", userId, "Completed");

        List<TaskDTO> tasks = Arrays.asList(task1, task2);
        Mockito.when(taskService.getTasksByUser(userId)).thenReturn(tasks);

        List<TaskDTO> result = taskService.getTasksByUser(userId);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTasksByDepartment() {
        String departmentId = "Dept1";
        TaskDTO task1 = new TaskDTO("Task1", "Description1", "User1", "Pending");
        TaskDTO task2 = new TaskDTO("Task2", "Description2", "User2", "Completed");

        List<TaskDTO> tasks = Arrays.asList(task1, task2);
        Mockito.when(taskService.getTasksByDepartment(departmentId)).thenReturn(tasks);

        List<TaskDTO> result = taskService.getTasksByDepartment(departmentId);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTasksByArea() {
        String areaId = "Area1";
        TaskDTO task1 = new TaskDTO("Task1", "Description1", "User1", "Pending");
        TaskDTO task2 = new TaskDTO("Task2", "Description2", "User2", "Completed");

        List<TaskDTO> tasks = Arrays.asList(task1, task2);
        Mockito.when(taskService.getTasksByArea(areaId)).thenReturn(tasks);

        List<TaskDTO> result = taskService.getTasksByArea(areaId);
        assertEquals(2, result.size());
    }
}
