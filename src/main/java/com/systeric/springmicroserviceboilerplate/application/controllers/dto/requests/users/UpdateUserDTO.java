package com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDTO {
    public String name;
    public int age;
    public String address;
}
