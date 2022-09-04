package com.rvalessandro.springmicroserviceboilerplate.application.controllers;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUsersDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserServiceAdapter;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserServiceAdapter userServiceAdapter;
    private UserRepositoryAdapter userRepositoryAdapter;
    private static Logger logger;

    @GetMapping
    private List<GetUsersDTO> getUser() {
        return userRepositoryAdapter.findAllUsers();
    }

    @PostMapping
    private void createUser(@RequestBody CreateUserDTO createUserDTO) throws Exception {
        userServiceAdapter.createUser(createUserDTO);
        // TODO Map to Response DTO and return value
    }
}
