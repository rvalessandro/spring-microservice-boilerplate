package com.systeric.springmicroserviceboilerplate.domain.models.users;

import com.systeric.springmicroserviceboilerplate.domain.models.vo.Address;
import com.systeric.springmicroserviceboilerplate.domain.models.vo.Age;
import com.systeric.springmicroserviceboilerplate.domain.models.vo.Name;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.entities.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
    private UUID id;
    private Name name;
    private Address address;
    private Age age;

    public User(Name name, Address address, Age age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public User(UserEntity user) throws ValidationException {
        this.id = user.getId();
        this.name = new Name(user.getName());
        this.address = new Address(user.getAddress());
        this.age = new Age(user.getAge());
    }
}
