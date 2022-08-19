package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public void createUser(User user) {
        // Do Logic Here
        // Call Repository Adapter
    }
}
