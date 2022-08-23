package com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.entities.UserEntity;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryAdapter {
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll().stream().map(User::new).collect(Collectors.toList());
    }

    public void createUser(User userModel) {
        // TODO Use Model Mapper
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModel.getName().getValue());
        userRepository.save(userEntity);
    }
}
