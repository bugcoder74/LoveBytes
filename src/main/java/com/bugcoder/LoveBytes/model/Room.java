package com.bugcoder.LoveBytes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Room {
    private final String roomCode;
    private final String hostId;
    private final Set<String> participants;

    public Room(String roomCode, String hostId) {
        this.roomCode = roomCode;
        this.hostId = hostId;
        this.participants = ConcurrentHashMap.newKeySet();
    }

    public String getRoomCode() {
        return roomCode;
    }


    public String getHostId() {
        return hostId;
    }

    public boolean addParticipant(String participantId){
        return participants.add(participantId);
    }

    public List<String> getParticipants(){
        return List.copyOf(participants);
    }
}

