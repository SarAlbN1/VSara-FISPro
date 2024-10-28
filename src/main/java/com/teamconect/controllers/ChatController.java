package com.teamconect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamconect.models.ChatMessage;
import com.teamconect.services.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        return chatService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<ChatMessage> getMessages(@RequestParam String userId) {
        return chatService.getMessagesByUserId(userId);
    }
}
