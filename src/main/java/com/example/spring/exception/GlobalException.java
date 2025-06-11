package com.example.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotfound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotfound resourceNotfound, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                resourceNotfound.getMessage(),
                webRequest.getDescription(false),
                "USER NOT FOUND"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<ErrorDetails> handleEmailIdAlreadyExists(EmailAlreadyExists emailAlreadyExists, WebRequest webRequest){

        ErrorDetails errorDetails1 = new ErrorDetails(
                LocalDateTime.now(),
                emailAlreadyExists.getMessage(),
                webRequest.getDescription(false),
                "EMAIL ALREADY EXISTS"
        );

        return new ResponseEntity<>(errorDetails1, HttpStatus.BAD_REQUEST);
    }
}
