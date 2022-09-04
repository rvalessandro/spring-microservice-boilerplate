package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;

public interface IUserService {
    void createUser(User user) throws Exception;
}
