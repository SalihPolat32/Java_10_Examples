package com.bilgeadam.main;

import com.bilgeadam.repository.AddressRepository;
import com.bilgeadam.repository.UserInformationRepository;
import com.bilgeadam.repository.UsersRepository;
import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.repository.entity.Users;

/*
 * Library Managment System
 * Author
 * Address
 * Book
 * User
 * UserInformation
 * Kullanıcılar kitap alabilirler bunun için gerekli sınıflar varsa onlarıda yazalım
 * User'da sadece giriş yapmak için gerekli bilgiler tutulsun
 * UserInformation'da diğer profil bilgilerimizi tutalım
 */
public class Main {

    public static void main(String[] args) {

        UsersRepository userRepository = new UsersRepository();

        UserInformationRepository userInformationRepository = new UserInformationRepository();

        AddressRepository addressRepository = new AddressRepository();

        // Adres Kayıt İşlemi
        Address address = Address.builder().city("Ankara").country("Türkiye").build();

        addressRepository.save(address);

        // User Information Kayıt İşlemi
//        UserInformation userInformation = UserInformation.builder().firstName("Mustafa").lastName("ÖZTÜRK").address(address).build();
//
//        userInformationRepository.save(userInformation);

        // User Kayıt İşlemi
//        Users user = Users.builder().username("musty").password("123456").userInformation(userInformation).build();
//
//        userRepository.save(user);

        Users user2 = Users.builder().username("mustafa").password("456789").build();

        userRepository.save(user2);
    }
}