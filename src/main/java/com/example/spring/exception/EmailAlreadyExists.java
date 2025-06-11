package com.example.spring.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExists extends RuntimeException{

    String message;

    public EmailAlreadyExists(String message) {
        super(message);

    }
}
