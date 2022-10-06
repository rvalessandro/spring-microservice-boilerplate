package com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users;

import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.entities.users.UserEntity;
import com.systeric.springmicroserviceboilerplate.infrastructure.repositories.users.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@AllArgsConstructor
public class UserServiceRepositoryAdapter implements IUserServiceRepositoryAdapter {
    UserRepository userRepository;
    ModelMapper modelMapper;

    @Override
    public User createUser(User userModel) throws ValidationException {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModel.getName().getValue());
        userEntity.setAddress(userModel.getAddress().getValue());
        userEntity.setAge(userModel.getAge().getValue());

        UserEntity newUserEntity = userRepository.save(userEntity);

        return new User(newUserEntity);
    }

    @Override
    public User updateUser(User userModel) throws NotFoundException, ValidationException {
        UserEntity userEntity = userRepository.findById(UUID.fromString(userModel.getId().toString()))
                .orElseThrow(() -> new NotFoundException(userModel.getId().toString(), "User"));

        userEntity.setName(userModel.getName().getValue());
        userEntity.setAddress(userModel.getAddress().getValue());
        userEntity.setAge(userModel.getAge().getValue());

        UserEntity updatedUser = userRepository.save(userEntity);

        return new User(updatedUser);
    }
}
