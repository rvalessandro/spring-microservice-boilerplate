package com.rvalessandro.springmicroserviceboilerplate.domain.adapters;

import com.rvalessandro.springmicroserviceboilerplate.application.controllers.dto.CreateUserDTO;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.IUserService;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.IProducer;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data.UserCreatedEventObject;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class UserControllerAdapter {
    private IUserService userService;
    private final IProducer producer;

    public void createUser(CreateUserDTO dto) throws Exception {
        Name name = new Name(dto.getName());
        User user = new User(name);

        // Publish to kafka
        UserCreatedEventObject eventObject = new UserCreatedEventObject(user);
        producer.publish(eventObject);
    }

}
