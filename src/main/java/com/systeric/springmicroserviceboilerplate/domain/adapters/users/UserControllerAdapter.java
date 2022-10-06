package com.systeric.springmicroserviceboilerplate.domain.adapters.users;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.CreateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.UpdateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.UserDTO;
import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.domain.models.vo.Address;
import com.systeric.springmicroserviceboilerplate.domain.models.vo.Age;
import com.systeric.springmicroserviceboilerplate.domain.models.vo.Name;
import com.systeric.springmicroserviceboilerplate.domain.services.users.IUserService;
import com.systeric.springmicroserviceboilerplate.foundation.exception.KafkaPublishException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.IProducer;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.users.UserCreatedEventObject;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.users.UserUpdatedEventObject;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@AllArgsConstructor
@Configuration
public class UserControllerAdapter implements IUserControllerAdapter {
    private final IProducer producer;
    private IUserService userService;

    @Override
    public UserDTO createUser(CreateUserDTO dto) throws KafkaPublishException, ValidationException {
        User user = User.builder()
                .name(new Name(dto.getName()))
                .address(new Address(dto.getAddress()))
                .age(new Age(dto.getAge()))
                .build();

        User createdUser = userService.createUser(user);

        // Example Publish to kafka
        UserCreatedEventObject eventObject = new UserCreatedEventObject(createdUser);
        producer.publish(eventObject);

        return new UserDTO(createdUser);
    }

    @Override
    public UserDTO updateUser(String userId, UpdateUserDTO dto) throws NotFoundException, ValidationException, KafkaPublishException {
        User user = User.builder()
                .id(UUID.fromString(userId))
                .name(new Name(dto.getName()))
                .address(new Address(dto.getAddress()))
                .age(new Age(dto.getAge()))
                .build();

        User updatedUser = userService.updateUser(user);

        UserUpdatedEventObject eventObject = new UserUpdatedEventObject(updatedUser);
        producer.publish(eventObject);

        return new UserDTO(updatedUser);
    }
}
