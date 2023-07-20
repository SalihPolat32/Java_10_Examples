package com.salihpolat.controller;

import com.salihpolat.repository.entity.Users;
import com.salihpolat.service.UsersService;

public class UsersController{

    private UsersService usersService;

    public UsersController() {
        this.usersService = new UsersService();
    }

    public Users save(Users users) {
        return usersService.save(users);
    }
}