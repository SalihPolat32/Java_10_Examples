package com.salihpolat.service;

import com.salihpolat.repository.AuthorRepository;
import com.salihpolat.repository.ICrud;
import com.salihpolat.repository.entity.Author;

import java.util.List;
import java.util.Optional;

public class AuthorService implements ICrud<Author> {

    private AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.update(author);
    }

    @Override
    public void deleteById(Long id) {

        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}