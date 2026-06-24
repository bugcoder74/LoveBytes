package com.bugcoder.LoveBytes.service;

import com.bugcoder.LoveBytes.dto.ChatMessage;
import com.bugcoder.LoveBytes.dto.ChatMessageResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ChatService {

    private final RoomService roomService;

    public ChatService(RoomService roomService) {
        this.roomService = roomService;
    }

    public ChatMessageResponse processChat(ChatMessage chatMessage, String roomCode){
        roomService.checkValidParticipation(chatMessage.participantId(), roomCode);
        return new ChatMessageResponse(
                    chatMessage.participantId(),
                    chatMessage.content(),
                    Instant.now().toString()
        );
    }

}
