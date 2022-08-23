package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCommandService implements IUserCommandService {
    private UserRepositoryAdapter userRepositoryAdapter;

    @Override
    public void createUser(User user) {
        // Do Logic Here
        userRepositoryAdapter.createUser(user);
    }
}
