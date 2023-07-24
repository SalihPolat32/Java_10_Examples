package com.bilgeadam.service;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService implements ICrud<User> {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            System.out.println("Böyle Bir Kullanıcı Bulunamadı!!!");
        }
        return user;
    }

    public Optional<User> findByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            System.out.println("Böyle Bir Kullanıcı Bulunamadı!!!");
        }
        return user;
    }
}