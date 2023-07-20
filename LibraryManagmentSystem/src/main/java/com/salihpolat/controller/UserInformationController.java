package com.salihpolat.controller;


import com.salihpolat.repository.entity.UserInformation;
import com.salihpolat.service.UserInformationService;

public class UserInformationController {

    private UserInformationService userInformationService;

    public UserInformationController() {
        this.userInformationService = new UserInformationService();
    }

    public UserInformation save(UserInformation userInformation) {
        return userInformationService.save(userInformation);
    }
}