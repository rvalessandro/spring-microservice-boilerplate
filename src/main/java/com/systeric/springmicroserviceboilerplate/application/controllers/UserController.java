package com.systeric.springmicroserviceboilerplate.application.controllers;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.params.PaginationParamRequest;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.CreateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.UpdateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUserByIDDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUsersDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.UserDTO;
import com.systeric.springmicroserviceboilerplate.domain.adapters.users.IUserControllerAdapter;
import com.systeric.springmicroserviceboilerplate.foundation.exception.KafkaPublishException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.foundation.responses.ListResponse;
import com.systeric.springmicroserviceboilerplate.foundation.responses.Response;
import com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users.IUserControllerRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private IUserControllerAdapter userControllerAdapter;
    private IUserControllerRepositoryAdapter userControllerRepositoryAdapter;

    @GetMapping
    private ListResponse<GetUsersDTO> getUsers(PaginationParamRequest param) {
        Page<GetUsersDTO> pageUsers = userControllerRepositoryAdapter.findAllUsers(param);

        return new ListResponse<>(pageUsers);
    }

    @GetMapping("/{userID}")
    private Response<GetUserByIDDTO> getUserById(@PathVariable String userID) throws NotFoundException {
        ThreadContext.put("User ID", userID);
        return new Response<>(userControllerRepositoryAdapter.getUserByID(userID));
    }

    @PostMapping
    private Response<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) throws KafkaPublishException, ValidationException {
        return new Response<>(userControllerAdapter.createUser(createUserDTO));
    }

    @PutMapping("/{userID}")
    private Response<UserDTO> updateUser(@PathVariable String userID, @RequestBody UpdateUserDTO updateUserDTO) throws ValidationException, NotFoundException, KafkaPublishException {
        return new Response<>(userControllerAdapter.updateUser(userID, updateUserDTO));
    }
}
