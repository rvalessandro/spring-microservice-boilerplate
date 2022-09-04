package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.kafka.Producer;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserServiceRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserServiceRepositoryAdapter userServiceRepositoryAdapter;

    private final Producer producer;

    @Override
    public void createUser(User user) throws Exception {
        // Do Logic Here
        // TODO: question, need to be move or not
//        userServiceRepositoryAdapter.createUser(user);
        producer.sendMessage(user);
    }
}
