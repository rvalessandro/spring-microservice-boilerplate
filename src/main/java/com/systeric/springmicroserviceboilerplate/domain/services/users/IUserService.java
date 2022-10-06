package com.systeric.springmicroserviceboilerplate.domain.services.users;

import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;

public interface IUserService {
    User createUser(User user) throws ValidationException;

    User updateUser(User user) throws NotFoundException, ValidationException;
}
