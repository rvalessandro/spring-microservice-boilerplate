package com.rvalessandro.springmicroserviceboilerplate.domain.services;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserQueryService implements IUserQueryService {
    private UserRepositoryAdapter userRepositoryAdapter;

    @Override
    public List<User> findUsers(User user) {
        return userRepositoryAdapter.findAllUsers();
    }
}
