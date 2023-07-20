package com.salihpolat.controller;

import com.salihpolat.repository.entity.Address;
import com.salihpolat.service.AddressService;

public class AddressController {

    private AddressService addressService;

    public AddressController() {
        this.addressService = new AddressService();
    }

    public Address save(Address address) {
        return addressService.save(address);
    }
}