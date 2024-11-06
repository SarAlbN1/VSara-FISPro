// src/main/java/com/teamconect/controllers/ChatWebSocketController.java

package com.teamconect.controllers;

import com.teamconect.models.ChatMessage;
import com.teamconect.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        chatService.saveMessage(message); // Guardar mensaje en la base de datos
        return message;
    }

    @MessageMapping("/chat.privateMessage")
    public void sendPrivateMessage(ChatMessage message) {
        chatService.saveMessage(message); // Guardar mensaje en la base de datos
        messagingTemplate.convertAndSendToUser(
                message.getReceiverId(), "/topic/private", message); // Enviar mensaje privado
    }
}
