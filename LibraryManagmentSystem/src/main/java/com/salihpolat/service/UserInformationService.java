package com.salihpolat.service;

import com.salihpolat.repository.ICrud;
import com.salihpolat.repository.UserInformationRepository;
import com.salihpolat.repository.entity.UserInformation;

import java.util.List;
import java.util.Optional;

public class UserInformationService implements ICrud<UserInformation> {

    private UserInformationRepository userInformationRepository;

    public UserInformationService() {
        this.userInformationRepository = new UserInformationRepository();
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return userInformationRepository.update(userInformation);
    }

    @Override
    public void deleteById(Long id) {

        userInformationRepository.deleteById(id);
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformationRepository.findAll();
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return userInformationRepository.findById(id);
    }
}