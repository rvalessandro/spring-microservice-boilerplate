package com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateUserDTO {
    private String name;
}
