package com.systeric.springmicroserviceboilerplate.domain.services.users;

import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import lombok.AllArgsConstructor;
import com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users.IUserServiceRepositoryAdapter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private IUserServiceRepositoryAdapter userServiceRepositoryAdapter;

    @Override
    public User createUser(User user) throws ValidationException {
        // Do Logic Here
        return userServiceRepositoryAdapter.createUser(user);
    }

    @Override
    public User updateUser(User user) throws NotFoundException, ValidationException {
        return userServiceRepositoryAdapter.updateUser(user);
    }
}
