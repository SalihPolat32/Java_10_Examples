package com.bilgeadam.service;

import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.Book;
import com.bilgeadam.repository.enums.EBookType;

import java.util.List;
import java.util.Optional;

public class BookService implements ICrud<Book> {

    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public void deleteById(Long id) {

        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByType(EBookType type) {

        return bookRepository.getBooksByType(type);
    }
}