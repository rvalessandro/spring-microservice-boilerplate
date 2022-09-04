package com.rvalessandro.springmicroserviceboilerplate.application.controllers;

import com.rvalessandro.springmicroserviceboilerplate.SpringMicroserviceBoilerplateApplication;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUserByIDDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUsersDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserServiceAdapter;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserServiceAdapter userServiceAdapter;
    private UserRepositoryAdapter userRepositoryAdapter;
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping
    private List<GetUsersDTO> getUser() {
        return userRepositoryAdapter.findAllUsers();
    }

    @GetMapping("/{userId}")
    private GetUserByIDDTO getUser(@PathVariable String userId) {
        ThreadContext.put("User ID", userId);
        logger.info("Fetching user by id");
        ThreadContext.clearAll();
        return userRepositoryAdapter.getUserByID(userId);
    }

    @PostMapping
    private void createUser(@RequestBody CreateUserDTO createUserDTO) {
        try {
            userServiceAdapter.createUser(createUserDTO); // TODO Map to Response DTO and return value
        } catch (Exception e) {
            logger.error("Unable to create user", e);
        }
    }
}
