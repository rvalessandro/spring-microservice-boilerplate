package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;

import java.util.List;

public interface IUserQueryService {
    List<User> findUsers(User user);
}
