package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserServiceRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserServiceRepositoryAdapter userServiceRepositoryAdapter;

    @Override
    public void createUser(User user) {
        // Do Logic Here
        userServiceRepositoryAdapter.createUser(user);
    }
}
