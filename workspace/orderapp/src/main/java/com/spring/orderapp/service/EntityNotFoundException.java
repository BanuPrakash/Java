package com.spring.orderapp.service;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
