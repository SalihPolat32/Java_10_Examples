package com.bilgeadam.main;

import com.bilgeadam.controller.AddressController;
import com.bilgeadam.controller.UserInformationController;
import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.repository.entity.UserInformation;

import java.util.Set;

public class MainManyToMany {

    public static void main(String[] args) throws InterruptedException {

        UserInformationController userInformationController = new UserInformationController();

        AddressController addressController = new AddressController();

        Address address1 = Address.builder().city("Ankara").build();
        Address address2 = Address.builder().city("Bolu").build();

        UserInformation userInformation1 = UserInformation.builder().firstName("Mustafa")
                .addresses(Set.of(address1, address2)).build();
        UserInformation userInformation2 = UserInformation.builder().firstName("Kemal")
                .addresses(Set.of(address1, address2)).build();

//        address1.getUserInformations().add(userInformation1);
//        address1.getUserInformations().add(userInformation2);
//        address2.getUserInformations().add(userInformation1);
//        address2.getUserInformations().add(userInformation2);

        userInformationController.save(userInformation1);
        userInformationController.save(userInformation2);

        Thread.sleep(2000);

        userInformationController.findAll().forEach(System.out::println);
    }
}