package com.bilgeadam.main;

import com.bilgeadam.controller.AuthorController;
import com.bilgeadam.controller.BookController;
import com.bilgeadam.repository.entity.Author;
import com.bilgeadam.repository.entity.Book;
import com.bilgeadam.repository.enums.EBookType;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

public class MainOneToMany {

    public static void main(String[] args) {

        AuthorController authorController = new AuthorController();

        BookController bookController = new BookController();

        Author author = Author.builder().firstName("Kemal").lastName("Tahir").build();

        Book book1 = Book.builder().title("Hür Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book2 = Book.builder().title("Esir Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book3 = Book.builder().title("Yorgun Savaşçı").bookType(EBookType.HISTORY).author(author).build();
/*
        author.setBooks(List.of(book1, book2, book3));

        authorController.save(author);
*/
        bookController.save(book1);
        bookController.save(book2);
        bookController.save(book3);

        Session session = HibernateUtility.getSESSION_FACTORY().openSession();

        String hql = "SELECT a FROM Author AS a WHERE a.id = 1";

        TypedQuery<Author> typedQuery = session.createQuery(hql, Author.class);

        Author newAuthor = typedQuery.getSingleResult();

        System.out.println(newAuthor.getFirstName());

        System.out.println(newAuthor.getBooks());

        session.close();
    }
}