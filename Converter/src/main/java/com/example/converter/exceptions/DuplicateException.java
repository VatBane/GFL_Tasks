package com.example.converter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}
