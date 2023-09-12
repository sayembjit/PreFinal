package com.mottakin.onlineBookLibraryApplication.controller;

import com.mottakin.onlineBookLibraryApplication.entity.BookEntity;
import com.mottakin.onlineBookLibraryApplication.exception.BookNotFoundException;
import com.mottakin.onlineBookLibraryApplication.service.impl.BookManagementServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookManagementController {
    /*private BookManagementServiceImpl bookManagementServiceImpl;

    @PostMapping("/books/create")
    public ResponseEntity<?> createBook(@RequestBody BookEntity book) {
        try {
            BookEntity createdBook = bookManagementServiceImpl.createBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }*/
}
