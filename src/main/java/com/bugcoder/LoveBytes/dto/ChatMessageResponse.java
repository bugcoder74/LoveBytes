package com.bugcoder.LoveBytes.dto;

public record ChatMessageResponse(
        String participantId,
        String content,
        String timestamp
){
}
