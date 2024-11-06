package dtosTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.teamconect.dtos.TaskDTO;

public class TaskDTOTest {

    @Test
    public void testConstructorAndGetters() {
        TaskDTO taskDTO = new TaskDTO("Task Title", "Task Description", "user123", "Pending");

        assertEquals("Task Title", taskDTO.getTitle());
        assertEquals("Task Description", taskDTO.getDescription());
        assertEquals("user123", taskDTO.getAssignedUserId());
        assertEquals("Pending", taskDTO.getStatus());
    }

    @Test
    public void testSetters() {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setTitle("Task Title");
        taskDTO.setDescription("Task Description");
        taskDTO.setAssignedUserId("user123");
        taskDTO.setStatus("Pending");

        assertEquals("Task Title", taskDTO.getTitle());
        assertEquals("Task Description", taskDTO.getDescription());
        assertEquals("user123", taskDTO.getAssignedUserId());
        assertEquals("Pending", taskDTO.getStatus());
    }
}
