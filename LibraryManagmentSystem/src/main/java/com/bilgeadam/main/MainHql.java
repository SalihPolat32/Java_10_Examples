package com.bilgeadam.main;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.repository.enums.EBookType;

/*
 * 1) Türü novel olan kitapların listesi;
 *
 * 2) İsmi A ile Başlayan Yazarların Kitaplarını Getirelim
 */
public class MainHql {

    public static void main(String[] args) {

        BookController bookController = new BookController();

        BookRepository bookRepository = new BookRepository();

//        bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
//
//        bookRepository.getBooksByType().forEach(System.out::println);
//
//        bookRepository.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);
//
//        bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);

        bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);
    }
}