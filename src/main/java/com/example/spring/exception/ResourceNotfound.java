package com.example.spring.exception;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotfound extends RuntimeException{

    private String user;
    private String filed;
    private Long id;

    public ResourceNotfound(String user, String filed, Long id) {
        super(String.format("%s not found with %s : '%s'", user, filed, id));
        this.user = user;
        this.filed = filed;
        this.id = id;
    }
}
