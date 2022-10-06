package com.systeric.springmicroserviceboilerplate.domain.adapters.users;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.CreateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.users.UpdateUserDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.UserDTO;
import com.systeric.springmicroserviceboilerplate.foundation.exception.KafkaPublishException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;

public interface IUserControllerAdapter {

    UserDTO createUser(CreateUserDTO dto) throws KafkaPublishException, ValidationException;

    UserDTO updateUser(String userId, UpdateUserDTO dto) throws NotFoundException, ValidationException, KafkaPublishException;
}
