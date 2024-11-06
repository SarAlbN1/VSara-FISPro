package controllersTEST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.controllers.TaskController;
import com.teamconect.models.Task;
import com.teamconect.services.TaskService;

public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTasksByUser_ReturnsTasks() {
        when(taskService.getTasksByUser(anyLong())).thenReturn(List.of(new Task()));

        List<Task> result = taskController.getTasksByUser(1L).getBody();
        assertFalse(result.isEmpty());
    }

    @Test
    void getTasksByDepartment_ReturnsTasks() {
        when(taskService.getTasksByDepartment(anyLong())).thenReturn(List.of(new Task()));

        List<Task> result = taskController.getTasksByDepartment(1L).getBody();
        assertFalse(result.isEmpty());
    }

    @Test
    void getTasksByArea_ReturnsTasks() {
        when(taskService.getTasksByArea(anyLong())).thenReturn(List.of(new Task()));

        List<Task> result = taskController.getTasksByArea(1L).getBody();
        assertFalse(result.isEmpty());
    }
}
