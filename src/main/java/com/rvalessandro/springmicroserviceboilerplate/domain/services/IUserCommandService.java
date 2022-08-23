package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;

public interface IUserCommandService {
    void createUser(User user);
}
