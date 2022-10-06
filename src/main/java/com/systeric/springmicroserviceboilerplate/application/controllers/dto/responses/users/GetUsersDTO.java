package com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetUsersDTO {
    private String id;
    private String name;
    private String address;
    private int age;
}
