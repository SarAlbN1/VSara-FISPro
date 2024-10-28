package com.teamconect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamconect.models.ChatMessage;
import com.teamconect.repositories.MessageRepository;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return messageRepository.save(message);
    }

    public List<ChatMessage> getMessagesByUserId(String userId) {
        return messageRepository.findByUserId(userId);
    }
}
