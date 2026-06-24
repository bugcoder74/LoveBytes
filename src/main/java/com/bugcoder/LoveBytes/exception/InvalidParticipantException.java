package com.bugcoder.LoveBytes.exception;

public class InvalidParticipantException extends RuntimeException{
    public InvalidParticipantException(){
        super("Client not a participant of Room");
    }
}
