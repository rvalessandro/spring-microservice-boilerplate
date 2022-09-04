package com.rvalessandro.springmicroserviceboilerplate.domain.adapters;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.IUserCommandService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class UserServiceAdapter {
    private IUserCommandService userService;

    public void createUser(CreateUserDTO dto) throws Exception {
        Name name = new Name(dto.getName());
        User user = new User(name);

        userService.createUser(user);
    }

}
