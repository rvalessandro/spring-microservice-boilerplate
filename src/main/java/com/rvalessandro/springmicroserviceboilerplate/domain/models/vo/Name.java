package com.rvalessandro.springmicroserviceboilerplate.domain.models.vo;

import com.rvalessandro.springmicroserviceboilerplate.foundation.exception.ValidationException;
import lombok.Getter;

@Getter
public class Name {
    private String value;

    public Name(String name) throws ValidationException {
        if(name.length() > 30) {
            throw new ValidationException("Name is too long");
        }
        if (name.length() < 1) {
            throw new ValidationException("Name is too short");
        }

        value = name;
    }
}
