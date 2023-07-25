package com.bilgeadam.main;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.repository.BorrowRepository;
import com.bilgeadam.repository.enums.EBookType;

import java.util.Arrays;
import java.util.List;

/*
 * 1) Türü Novel Olan Kitapların Listesi;
 *
 * 2) İsmi A ile Başlayan Yazarların Kitaplarını Getirelim
 *
 * 3) Kitap Ara Fonksiyonunu title'a Göre Kitap Getiren Metodu Yazalım
 *
 * 4) 1 Kullanıcının Yaptığı Ödünç Almalar
 *
 * 5) 1 Kitabı Hangi Kullanıcılar Kiralamış
 *
 * 6) Her Kitap Türünden Kaç Adet Kitap Vardır Story - 2, History - 3, Novel - 6
 *
 * 7) Ödünç Alma Metodu ===>
 *
 * Kiralanabilir Kitapları Listeleyeceğiz
 * Daha Sonra Bir Kullanıcı Bilgisi Alacağız
 * Daha Sonra Kaç Gün Kiralamak İstediğimizi Gireceğiz Ve Sonunda Bir Kiralama Gerçekleştireceğiz
 * (Uyarı: Kiralama Sonucu Gerçekleşen Değişiklikleri Database Üzerinde Güncellemeyi Unutmayın)
 */
public class MainHql {

    public static void main(String[] args) {

        BookController bookController = new BookController();

        BookRepository bookRepository = new BookRepository();

        BorrowRepository borrowRepository = new BorrowRepository();

//        bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
//
//        bookRepository.getBooksByType().forEach(System.out::println);
//
//        bookRepository.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);
//
//        bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);
//
//        bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);
//
//        System.out.println(bookRepository.findByTitle("Sevme Sanatı"));
//
//        System.out.println(bookRepository.findByTitle2("Yabancı"));
//
//        System.out.println(bookRepository.findByTitleWithCrieria("Yabancı"));
//
//        List<Object[]> list = bookRepository.findByTitleWithCrieria2("Yabancı");
//
//        for (Object[] array : list) {
//            System.out.println(Arrays.toString(array));
//        }
//
//        borrowRepository.findByUserId(1L).forEach(System.out::println);
//
//        borrowRepository.findByUserWithBookId(1L).forEach(System.out::println);
//
//        List<Object[]> list2 = bookRepository.getBooksCountByBookType();
//
//        for (Object[] array : list2) {
//            System.out.println(Arrays.toString(array));
//        }
//
//        List<Object[]> list3 = bookRepository.getBooksCountByBookTypeWithCriteria();
//
//        for (Object[] array : list3) {
//            System.out.println(Arrays.toString(array));
//        }

        List<Object[]> list = bookRepository.getBooksCountByBookTypeWithNamedQuery();

        for (Object[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}