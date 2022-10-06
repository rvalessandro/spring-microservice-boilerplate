package com.systeric.springmicroserviceboilerplate.domain.models.vo;

import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Age {
    private int value;

    public Age(int age) throws ValidationException {
        if (age < 1) {
            throw new ValidationException("Age can't be zero");
        }

        value = age;
    }
}