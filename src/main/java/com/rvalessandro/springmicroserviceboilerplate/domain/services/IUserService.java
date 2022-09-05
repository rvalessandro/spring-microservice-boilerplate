package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;

public interface IUserService {
    void createUser(User user) throws Exception;

    void createUserByKafka(User user);

}
