package com.teamconect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamconect.models.ChatMessage;

public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByUserId(Long userId);
}
