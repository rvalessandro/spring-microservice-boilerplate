package com.rvalessandro.springmicroserviceboilerplate.application.controllers;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserServiceAdapter;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.IUserService;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
@AllArgsConstructor
public class UserController {
    private UserServiceAdapter userServiceAdapter;

    @PostMapping
    private void createUser(@RequestBody CreateUserDTO createUserDTO) throws Exception {
        userServiceAdapter.createUser(createUserDTO);
        // Map to Response DTO and return value
    }
}
