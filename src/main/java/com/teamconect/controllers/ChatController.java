package com.teamconect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
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

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(ChatMessage message) {
        chatService.saveMessage(message);
        messagingTemplate.convertAndSendToUser(
            message.getReceiverId(),
            "/topic/private",
            message
            
        );
    }
    
}
