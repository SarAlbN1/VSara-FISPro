package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.teamconect.models.ChatMessage;
import com.teamconect.services.ChatService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Método para enviar mensajes privados
    @MessageMapping("/chat.privateMessage")
    public void sendPrivateMessage(ChatMessage message) {
        chatService.saveMessage(message);
        messagingTemplate.convertAndSendToUser(
            message.getReceiverId(),
            "/topic/private",
            message
        );
    }

    // Método para enviar mensajes públicos
    @MessageMapping("/chat.publicMessage")
    @SendTo("/topic/public")
    public ChatMessage sendPublicMessage(ChatMessage message) {
        chatService.saveMessage(message);
        return message;
    }
}
