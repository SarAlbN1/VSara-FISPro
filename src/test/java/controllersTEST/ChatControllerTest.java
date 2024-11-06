package controllersTEST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.teamconect.controllers.ChatController;
import com.teamconect.models.ChatMessage;
import com.teamconect.services.ChatService;

public class ChatControllerTest {

    @InjectMocks
    private ChatController chatController;

    @Mock
    private ChatService chatService;

    @Test
    void sendPrivateMessage_CallsSaveMessage() {
        ChatMessage message = new ChatMessage();
        message.setSenderId("1");
        message.setReceiverId("2");
        message.setContent("Hello");

        when(chatService.saveMessage(any(ChatMessage.class))).thenReturn(message);

        // Llamamos al método de mensaje privado
        chatController.sendPrivateMessage(message);

        // Verificamos que el servicio haya guardado el mensaje
        verify(chatService).saveMessage(message);
    }

    @Test
    void sendPublicMessage_CallsSaveMessage() {
        ChatMessage message = new ChatMessage();
        message.setSenderId("1");
        message.setContent("Hello everyone");

        when(chatService.saveMessage(any(ChatMessage.class))).thenReturn(message);

        // Llamamos al método de mensaje público
        chatController.sendPublicMessage(message);

        // Verificamos que el servicio haya guardado el mensaje
        verify(chatService).saveMessage(message);
    }

    @Test
    void getMessagesByUserId_ReturnsMessages() {
        ChatMessage message = new ChatMessage();
        message.setSenderId("1");
        message.setReceiverId("2");
        message.setContent("Test Message");

        when(chatService.getMessagesByUserId(anyLong())).thenReturn(List.of(message));

        List<ChatMessage> result = chatService.getMessagesByUserId(1L);
        assertFalse(result.isEmpty());
        assertNotNull(result.get(0).getSenderId());
        assertNotNull(result.get(0).getReceiverId());
    }
}
