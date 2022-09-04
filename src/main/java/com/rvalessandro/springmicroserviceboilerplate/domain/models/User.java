package com.rvalessandro.springmicroserviceboilerplate.domain.models;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private Name name;

    public User(UserEntity user) throws ValidationException {
        this.name = new Name(user.getName());
    }
}
