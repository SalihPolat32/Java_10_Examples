package com.salihpolat.controller;

import com.salihpolat.repository.entity.Author;
import com.salihpolat.service.AuthorService;

public class AuthorController {

    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public Author save(Author author) {
        return authorService.save(author);
    }
}