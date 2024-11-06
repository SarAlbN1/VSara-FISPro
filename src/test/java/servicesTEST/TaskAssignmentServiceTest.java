package servicesTEST;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.models.Task;
import com.teamconect.models.User;
import com.teamconect.repositories.TaskRepository;
import com.teamconect.repositories.UserRepository;
import com.teamconect.services.NotificationService;
import com.teamconect.services.TaskAssignmentService;

public class TaskAssignmentServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private TaskAssignmentService taskAssignmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAssignTaskToUser_TaskAndUserExist() {
        Long taskId = 1L;
        Long userId = 2L;

        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Test Task");

        User user = new User();
        user.setId(userId);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskAssignmentService.assignTaskToUser(taskId, userId);

        assertNotNull(result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(userRepository, times(1)).findById(userId);
        verify(taskRepository, times(1)).save(task);

        // Verificar que se crea una notificación
        String expectedMessage = "Se te ha asignado una nueva tarea: " + task.getTitle();
        verify(notificationService, times(1)).createNotification(expectedMessage, userId);
    }

    @Test
    public void testAssignTaskToUser_TaskOrUserDoesNotExist() {
        Long taskId = 1L;
        Long userId = 2L;

        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        Task result = taskAssignmentService.assignTaskToUser(taskId, userId);

        assertNull(result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(userRepository, times(1)).findById(userId);
        verify(taskRepository, times(0)).save(any(Task.class));
        verify(notificationService, times(0)).createNotification(anyString(), anyLong());
    }
}
