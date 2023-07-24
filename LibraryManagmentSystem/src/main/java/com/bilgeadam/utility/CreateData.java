package com.bilgeadam.utility;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.controller.BorrowController;
import com.bilgeadam.controller.UsersController;
import com.bilgeadam.repository.entity.*;
import com.bilgeadam.repository.enums.EBookType;
import com.bilgeadam.repository.enums.EStatus;
import com.bilgeadam.repository.entity.Author;

import java.time.LocalDate;
import java.util.Set;

public class CreateData {
    public static void createData() {

        Author author = Author.builder().firstName("Kemal").lastName("TAHİR").build();

        BookController bookController = new BookController();

        Book book = Book.builder().
                title("Hür Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();

        Book book2 = Book.builder().
                title("Esir Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();

        Book book3 = Book.builder().
                title("Yorgun Savaşçı").bookType(EBookType.HISTORY).author(author).build();

        bookController.save(book);
        bookController.save(book2);
        bookController.save(book3);

        Author author1 = Author.builder().firstName("Albert").lastName("CAMUS").build();
        Book book4 = Book.builder().title("Yabancı").bookType(EBookType.NOVEL).author(author1).build();
        Book book5 = Book.builder().title("Mutlu Ölüm").bookType(EBookType.NOVEL).author(author1).build();
        Book book6 = Book.builder().title("Sisifos Söyleni").bookType(EBookType.NOVEL).author(author1).build();

        bookController.save(book4);
        bookController.save(book5);
        bookController.save(book6);

        Author author3 = Author.builder().firstName("Sait Faik").lastName("ABASIYANIK").build();
        Book book7 = Book.builder().title("Son Kuşlar").bookType(EBookType.STORY).author(author3).build();
        Book book8 = Book.builder().title("Yabancı").bookType(EBookType.STORY).author(author3).build();
        bookController.save(book7);
        bookController.save(book8);

        Author author4 = Author.builder().firstName("Nikolay").lastName("GOGOL").build();
        Book book9 = Book.builder().title("Ölü Canlar").bookType(EBookType.NOVEL).author(author3).build();
        bookController.save(book9);


        Author author5 = Author.builder().firstName("Erich").lastName("FROM").build();

        Book book10 = Book.builder().title("Özgürlükten Kaçış").bookType(EBookType.NOVEL).author(author5).build();
        Book book11 = Book.builder().title("Sevme Sanatı").bookType(EBookType.NOVEL).author(author5).build();
        bookController.save(book10);
        bookController.save(book11);

        // user Oluşturma
        Address address1 = Address.builder().country("Turkiye").city("Ankara").build();
        Address address2 = Address.builder().country("Türkiye").city("Balıkesir").build();
        Address address3 = Address.builder().country("Türkiye").city("Konya").build();
        Address address4 = Address.builder().country("Türkiye").city("İzmir").build();
        Address address5 = Address.builder().country("Türkiye").city("Amasya").build();
        Address address6 = Address.builder().country("Türkiye").city("Erzincan").build();

        UserInformation userInformation = UserInformation.builder().firstName("Mustafa")
                .lastName("ÖZTÜRK")

                .phoneNumber("5555-555-55-5")
                .about("Hakkımda........")
                .addresses(Set.of(address1, address2))
                .build();

        UserInformation userInformation2 = UserInformation.builder().firstName("Tuba")
                .lastName("ÖZTÜRK")

                .phoneNumber("5555-555-55-5")
                .about("Hakkımda........")
                .addresses(Set.of(address1, address3, address4))
                .build();

        UserInformation userInformation3 = UserInformation.builder().firstName("Derya")
                .lastName("ÖZTÜRK")

                .phoneNumber("5555-555-55-5")
                .about("Hakkımda........")
                .addresses(Set.of(address5, address6))
                .build();

        Users user = Users.builder().username("musty").password("123")
                .userInformation(userInformation)
                .build();
        Users user2 = Users.builder().username("tuba").password("123").userInformation(userInformation2).build();
        Users user3 = Users.builder().username("derya").password("123").userInformation(userInformation3).build();

        UsersController usersController = new UsersController();

        usersController.save(user);
        usersController.save(user2);
        usersController.save(user3);

        Borrow borrow1 = Borrow.builder()
                .book(book)
                .users(user)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(8))
                .build();

        /// Önce 5 Günlük Kiralama Yaptık
        book.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book);

        // Daha Sonra 5 Gün Sonra Kiralanan Kitabın Geri İade Olduğu Bir Senaryo Oluşturduk
        book.setStatus(EStatus.AVAILABLE);
        bookController.update(book);

        // Daha Sonra Aynı Kitabı Başka Bir Kullanıcı Tekrardan Kiraldı
        Borrow borrow2 = Borrow.builder()
                .book(book)
                .users(user2)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(2))
                .build();

        book.setStatus(EStatus.UNAVAILABLE);

        bookController.update(book);
        Borrow borrow3 = Borrow.builder()
                .book(book6)
                .users(user)
                .period(10)
                .build();

        book6.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book6);
        Borrow borrow4 = Borrow.builder()
                .book(book5)
                .users(user)
                .period(10)
                .build();

        book5.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book5);

        BorrowController borrowController = new BorrowController();

        borrowController.save(borrow1);
        borrowController.save(borrow2);
        borrowController.save(borrow3);
        borrowController.save(borrow4);
    }

    public static void main(String[] args) {

        createData();
    }
}