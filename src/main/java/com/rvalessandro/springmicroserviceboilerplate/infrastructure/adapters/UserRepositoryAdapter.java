package com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.entities.UserEntity;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.repositories.UserRepository;

public class UserRepositoryAdapter {
    UserRepository userRepository;

    public void createUser(User userModel) {
        // TODO Use Model Mapper
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModel.getName().getValue());
        userRepository.save(userEntity);
    }
}
