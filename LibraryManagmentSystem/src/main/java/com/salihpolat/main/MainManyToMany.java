package com.salihpolat.main;

import com.salihpolat.controller.AddressController;
import com.salihpolat.controller.UserInformationController;
import com.salihpolat.repository.entity.Address;
import com.salihpolat.repository.entity.UserInformation;

import java.util.HashSet;
import java.util.Set;

public class MainManyToMany {

    public static void main(String[] args) {

        UserInformationController userInformationController = new UserInformationController();

        AddressController addressController = new AddressController();

        Address address1 = Address.builder().city("Ankara").build();
        Address address2 = Address.builder().city("Bolu").build();

        UserInformation userInformation1 = UserInformation.builder().firstName("Mustafa")
                .address(Set.of(address1, address2)).build();
        UserInformation userInformation2 = UserInformation.builder().firstName("Kemal")
                .address(Set.of(address1, address2)).build();

        userInformationController.save(userInformation1);
        userInformationController.save(userInformation2);

        address1.getUserInformations().add(userInformation1);
        address1.getUserInformations().add(userInformation2);
        address2.getUserInformations().add(userInformation1);
        address2.getUserInformations().add(userInformation2);
    }
}