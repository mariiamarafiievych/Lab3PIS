package com.example.demo.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException() {
        super("Object can`t be found!");
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
