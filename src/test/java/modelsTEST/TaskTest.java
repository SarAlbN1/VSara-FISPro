package modelsTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.teamconect.models.Task;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        // Cambiamos los valores de int y String a Long donde corresponde
        Task task = new Task("Design Module", "Create design for module", 123L, "pending", 1L, 2L);

        assertEquals("Design Module", task.getTitle());
        assertEquals("Create design for module", task.getDescription());
        assertEquals(123L, task.getAssignedUserId());
        assertEquals("pending", task.getStatus());
        assertEquals(1L, task.getDepartment());
        assertEquals(2L, task.getArea());
    }

    @Test
    public void testTaskStatusUpdate() {
        Task task = new Task("Design Module", "Create design for module", 123L, "pending", 1L, 2L);

        task.setStatus("completed");
        assertEquals("completed", task.getStatus());
    }

    @Test
    public void testTaskDepartmentUpdate() {
        Task task = new Task("Design Module", "Create design for module", 123L, "pending", 1L, 2L);

        // Cambiamos el valor del departamento a un Long en lugar de un String
        task.setDepartment(3L);
        assertEquals(3L, task.getDepartment());
    }

    @Test
    public void testTaskAreaUpdate() {
        Task task = new Task("Design Module", "Create design for module", 123L, "pending", 1L, 2L);

        // Cambiamos el valor del área a un Long en lugar de un String
        task.setArea(4L);
        assertEquals(4L, task.getArea());
    }
}
