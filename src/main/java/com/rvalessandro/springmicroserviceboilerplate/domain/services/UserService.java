package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.IProducer;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserServiceRepositoryAdapter;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data.UserCreatedEventObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserServiceRepositoryAdapter userServiceRepositoryAdapter;
    private final IProducer producer;

    @Override
    public void createUser(User user) throws Exception {
        // Do Logic Here
        userServiceRepositoryAdapter.createUser(user);

        // Publish to kafka
        UserCreatedEventObject eventObject = new UserCreatedEventObject(user);
        producer.publish(eventObject);
    }

    @Override
    public void createUserByKafka(User user) {
        // Do Logic Here
        userServiceRepositoryAdapter.createUser(user);
    }
}
