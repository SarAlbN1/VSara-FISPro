package repositoriesTEST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teamconect.models.ChatMessage;
import com.teamconect.repositories.MessageRepository;

@DataJpaTest
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testFindByUserId() {
        ChatMessage message1 = new ChatMessage();
        message1.setUserId(1L);
        message1.setContent("Hello!");

        ChatMessage message2 = new ChatMessage();
        message2.setUserId(1L);
        message2.setContent("How are you?");

        messageRepository.save(message1);
        messageRepository.save(message2);

        List<ChatMessage> messages = messageRepository.findByUserId(1L);
        assertEquals(2, messages.size());
    }
}
