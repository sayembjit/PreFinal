package com.mottakin.onlineBookLibraryApplication.controller;

import com.mottakin.onlineBookLibraryApplication.exception.BookAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<String> handleBookAlreadyExistsException(String MESSAGE) {
        return new ResponseEntity<>(MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
