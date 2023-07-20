package com.salihpolat.controller;

import com.salihpolat.repository.entity.Book;
import com.salihpolat.service.BookService;

public class BookController {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public Book save(Book book) {
        return bookService.save(book);
    }
}