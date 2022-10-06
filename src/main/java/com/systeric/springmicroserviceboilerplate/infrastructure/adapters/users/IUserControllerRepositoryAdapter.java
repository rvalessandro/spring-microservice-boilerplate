package com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.params.PaginationParamRequest;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUserByIDDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUsersDTO;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import org.springframework.data.domain.Page;

public interface IUserControllerRepositoryAdapter {
    Page<GetUsersDTO> findAllUsers(PaginationParamRequest param);

    GetUserByIDDTO getUserByID(String id) throws NotFoundException;
}
