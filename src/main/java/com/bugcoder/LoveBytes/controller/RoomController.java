package com.bugcoder.LoveBytes.controller;

import com.bugcoder.LoveBytes.model.Room;
import com.bugcoder.LoveBytes.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
