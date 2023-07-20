package com.salihpolat.main;

import com.salihpolat.repository.AddressRepository;
import com.salihpolat.repository.UserInformationRepository;
import com.salihpolat.repository.UsersRepository;
import com.salihpolat.repository.entity.Address;
import com.salihpolat.repository.entity.UserInformation;
import com.salihpolat.repository.entity.Users;

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