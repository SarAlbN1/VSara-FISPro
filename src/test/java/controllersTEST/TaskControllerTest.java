package controllersTEST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import com.teamconect.controllers.TaskController;
import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @Test
    void getTasksByUser_ReturnsTasks() {
        when(taskService.getTasksByUser(anyLong())).thenReturn(List.of(new Task()));

        var response = taskController.getTasksByUser(1L);
        assertNotNull(response);  // Verificar que la respuesta no es null
        List<Task> result = response.getBody();
        assertNotNull(result);  // Verificar que el cuerpo de la respuesta no es null
        assertFalse(result.isEmpty());
    }

    @Test
    void getTasksByDepartment_ReturnsTasks() {
        when(taskService.getTasksByDepartment(anyLong())).thenReturn(List.of(new Task()));

        var response = taskController.getTasksByDepartment(1L);
        assertNotNull(response);
        List<Task> result = response.getBody();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void getTasksByArea_ReturnsTasks() {
        when(taskService.getTasksByArea(anyLong())).thenReturn(List.of(new Task()));

        var response = taskController.getTasksByArea(1L);
        assertNotNull(response);
        List<Task> result = response.getBody();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
