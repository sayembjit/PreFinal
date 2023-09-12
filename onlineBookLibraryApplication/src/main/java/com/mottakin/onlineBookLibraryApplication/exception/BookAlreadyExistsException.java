package com.mottakin.onlineBookLibraryApplication.exception;

public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException(String MESSAGE) {
        super(MESSAGE);
    }
}
