package com.bugcoder.LoveBytes.controller;

import com.bugcoder.LoveBytes.dto.JoinRoomResponse;
import com.bugcoder.LoveBytes.exception.RoomNotFoundException;
import com.bugcoder.LoveBytes.model.Room;
import com.bugcoder.LoveBytes.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @PostMapping("/api/v1/public/rooms")
    public ResponseEntity<Room> createRoom(){
        Room room =  roomService.createRoom();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(room);
    }

    @GetMapping("/api/v1/admin/rooms")
    public Map<String, Room> getRooms(){
        return roomService.getAvailableRooms();
    }

    @PostMapping("/api/v1/public/rooms/{roomCode}/join")
    public ResponseEntity<JoinRoomResponse> joinRoom(@PathVariable String roomCode){
        try{
            JoinRoomResponse room = roomService.joinRoom(roomCode);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(room);
        }
        catch(RoomNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
