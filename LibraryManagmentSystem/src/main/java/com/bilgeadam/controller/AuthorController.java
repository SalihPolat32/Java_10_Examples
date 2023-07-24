package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Author;
import com.bilgeadam.service.AuthorService;

public class AuthorController {

    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public Author save(Author author) {
        return authorService.save(author);
    }
}