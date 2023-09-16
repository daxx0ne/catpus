package com.example.catpus.global.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
