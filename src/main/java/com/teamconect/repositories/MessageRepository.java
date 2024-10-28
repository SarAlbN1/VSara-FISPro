package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamconect.models.ChatMessage;

public interface MessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByUserId(String userId);
}
