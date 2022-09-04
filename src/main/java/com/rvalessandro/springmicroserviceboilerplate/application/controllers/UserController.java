package com.rvalessandro.springmicroserviceboilerplate.application.controllers;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUserByIDDTO;
import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.GetUsersDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserControllerAdapter;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserServiceRepositoryAdapter;
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
    private UserControllerAdapter userControllerAdapter;
    private UserServiceRepositoryAdapter userRepositoryAdapter;
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping
    private List<GetUsersDTO> getUsers() {
        return userRepositoryAdapter.findAllUsers();
    }

    @GetMapping("/{userId}")
    private GetUserByIDDTO getUserById(@PathVariable String userId) {
        ThreadContext.put("User ID", userId);
        logger.info("Fetching user by id");
        ThreadContext.clearAll();
        return userRepositoryAdapter.getUserByID(userId);
    }

    @PostMapping
    private void createUser(@RequestBody CreateUserDTO createUserDTO) {
        try {
            userControllerAdapter.createUser(createUserDTO); // TODO Map to Response DTO and return value
        } catch (Exception e) {
            logger.error("Unable to create user", e);
        }
    }
}
