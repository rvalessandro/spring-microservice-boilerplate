package com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUserByIDDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUsersDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.entities.UserEntity;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class UserRepositoryAdapter {
    UserRepository userRepository;
    ModelMapper modelMapper;

    public List<GetUsersDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, GetUsersDTO.class))
                .collect(Collectors.toList());
    }

    public GetUserByIDDTO getUserByID(String id) {
        return modelMapper.map(userRepository.findById(UUID.fromString(id)), GetUserByIDDTO.class);
    }

    public void createUser(User userModel) {
        // TODO Use Model Mapper
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModel.getName().getValue());
        userRepository.save(userEntity);
    }
}
