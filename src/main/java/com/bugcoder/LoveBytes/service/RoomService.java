package com.bugcoder.LoveBytes.service;

import com.bugcoder.LoveBytes.model.Room;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RoomService {

    private final AtomicLong counter = new AtomicLong(1); // will load from db later
    private  Map<String, Room> availableRooms = new ConcurrentHashMap<>();


    // Creating a room object
    public Room createRoom(){
        final String roomId = RoomIDGenerator.convertToBase62(counter.getAndIncrement());
        final String uuid = UUID.randomUUID().toString();
        Room room = new Room(roomId, uuid);
        this.availableRooms.put(roomId, room);
        return room;
    }

    public Map<String, Room> getAvailableRooms(){
        return Map.copyOf(availableRooms);
    }

    private static class RoomIDGenerator{
        private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        public static String convertToBase62(long n){
            StringBuilder code = new StringBuilder();
            if(n==0){
                n = 1;
            }
            while(n>0){
                int remainder = (int) n%62;
                code.append(BASE62.charAt(remainder));
                n = n/62;
            }
            return code.reverse().toString();
        }
    }

}