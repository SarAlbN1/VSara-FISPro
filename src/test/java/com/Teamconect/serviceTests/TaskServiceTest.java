package com.Teamconect.serviceTests;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    public void testUpdateTaskStatus() {
        // Configuración inicial de la tarea
        Task task = new Task("Titulo", "Descripcion", "user123", "pendiente");
        task.setId("task123");

        // Simulando el comportamiento del repositorio
        when(taskRepository.findById("task123")).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Ejecución de la lógica de actualización de estado
        Task updatedTask = taskService.updateTaskStatus("task123", "completado");

        // Validación del resultado
        assertEquals("completado", updatedTask.getStatus());
        verify(taskRepository, times(1)).save(task);
    }
}
