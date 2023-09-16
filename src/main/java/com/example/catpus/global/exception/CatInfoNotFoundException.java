package com.example.catpus.global.exception;

public class CatInfoNotFoundException extends RuntimeException {
    public CatInfoNotFoundException(String message) {
        super(message);
    }
}