package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Users;
import com.bilgeadam.service.UsersService;

public class UsersController{

    private UsersService usersService;

    public UsersController() {
        this.usersService = new UsersService();
    }

    public Users save(Users users) {
        return usersService.save(users);
    }
}