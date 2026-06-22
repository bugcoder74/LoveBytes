package com.bugcoder.LoveBytes.dto;

import com.bugcoder.LoveBytes.model.Room;

public record JoinRoomResponse(Room room, String participantId){
}
