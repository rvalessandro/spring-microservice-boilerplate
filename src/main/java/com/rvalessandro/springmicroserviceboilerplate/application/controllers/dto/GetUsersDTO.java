package com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetUsersDTO {
    private String id;
    private String name;
}
