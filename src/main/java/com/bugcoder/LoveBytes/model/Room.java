package com.bugcoder.LoveBytes.model;

public class Room {
    private final String roomCode;
    private final String hostId;

    public Room(String roomCode, String hostId) {
        this.roomCode = roomCode;
        this.hostId = hostId;
    }

    public String getRoomCode() {
        return roomCode;
    }


    public String getHostId() {
        return hostId;
    }

}

