package com.systeric.springmicroserviceboilerplate.domain.models.vo;

import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String value;

    public Address(String address) throws ValidationException {
        if (address.length() > 100) {
            throw new ValidationException("Address is too long");
        }
        if (address.length() < 1) {
            throw new ValidationException("Address is too short");
        }

        value = address;
    }
}
