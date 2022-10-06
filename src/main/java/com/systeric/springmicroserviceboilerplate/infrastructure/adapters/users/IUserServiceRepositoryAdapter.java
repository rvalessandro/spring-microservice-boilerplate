package com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users;

import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;

public interface IUserServiceRepositoryAdapter {
    User createUser(User userModel) throws ValidationException;

    User updateUser(User userModel) throws NotFoundException, ValidationException;
}
