package com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users;

import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String address;
    private int age;

    public UserDTO(User user) {
        this.id = user.getId().toString();
        this.name = user.getName().getValue();
        this.address = user.getAddress().getValue();
        this.age = user.getAge().getValue();
    }
}
