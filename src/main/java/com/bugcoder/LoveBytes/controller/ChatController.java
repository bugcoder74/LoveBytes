package com.bugcoder.LoveBytes.controller;

import com.bugcoder.LoveBytes.dto.ChatMessage;
import com.bugcoder.LoveBytes.dto.ChatMessageResponse;
import com.bugcoder.LoveBytes.service.ChatService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatService chatService) {
        this.messagingTemplate = messagingTemplate;
        this.chatService = chatService;
    }

    @MessageMapping("/{roomCode}/chat")
    public void sendMessage(
            @DestinationVariable String roomCode,
            @Payload ChatMessage chatMessage
            ){
        try {
            ChatMessageResponse response = chatService.processChat(chatMessage, roomCode);
            messagingTemplate.convertAndSend("/topic/" + roomCode + "/chat", response);
        }
        catch(RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}
