package com.systeric.springmicroserviceboilerplate.infrastructure.adapters.users;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.params.PaginationParamRequest;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUserByIDDTO;
import com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users.GetUsersDTO;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.utils.CustomPageImpl;
import com.systeric.springmicroserviceboilerplate.infrastructure.entities.users.UserEntity;
import com.systeric.springmicroserviceboilerplate.infrastructure.repositories.users.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

@Configuration
@AllArgsConstructor
public class UserControllerRepositoryAdapter implements IUserControllerRepositoryAdapter {
    UserRepository userRepository;
    ModelMapper modelMapper;
    CustomPageImpl customPageImpl;

    @Override
    public Page<GetUsersDTO> findAllUsers(PaginationParamRequest param) {
        //TODO : It will be used deletedBy or deletedAt later
        Specification<UserEntity> specs = (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("name"));
        Pageable pageable = customPageImpl.getCustomPageable(param);

        return userRepository.findAll(Specification.where(specs), pageable)
                .map(user -> modelMapper.map(user, GetUsersDTO.class));
    }

    @Override
    public GetUserByIDDTO getUserByID(String id) throws NotFoundException {
        UserEntity user = userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException(id, "User"));
        return modelMapper.map(user, GetUserByIDDTO.class);
    }
}
