package servicesTEST;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.teamconect.models.ChatMessage;
import com.teamconect.repositories.MessageRepository;
import com.teamconect.services.ChatService;

public class ChatServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private ChatService chatService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveMessage() {
        ChatMessage message = new ChatMessage();
        message.setContent("Hello");
        
        when(messageRepository.save(message)).thenReturn(message);

        ChatMessage result = chatService.saveMessage(message);
        assertNotNull(result);
        assertEquals("Hello", result.getContent());
    }

    @Test
    public void testGetMessagesByUserId() {
        Long userId = 1L;
        ChatMessage message1 = new ChatMessage();
        message1.setContent("Hello");
        ChatMessage message2 = new ChatMessage();
        message2.setContent("Hi");

        List<ChatMessage> messages = Arrays.asList(message1, message2);
        when(messageRepository.findByUserId(userId)).thenReturn(messages);

        List<ChatMessage> result = chatService.getMessagesByUserId(userId);
        assertEquals(2, result.size());
    }
}
