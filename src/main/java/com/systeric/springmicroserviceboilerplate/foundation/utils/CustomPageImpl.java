package com.systeric.springmicroserviceboilerplate.foundation.utils;

import com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.params.PaginationParamRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Configuration
@AllArgsConstructor
public class CustomPageImpl {

    public Pageable getCustomPageable(PaginationParamRequest param) {
        Sort sorting = Sort.by(param.getSortBy()).ascending();
        if (param.getOrderBy().equalsIgnoreCase("desc")) sorting = Sort.by(param.getSortBy()).descending();

        Pageable pageable;
        if (param.getLimit() < 0) {
            pageable = PageRequest.of(param.getPage(), 100, sorting);
        } else {
            pageable = PageRequest.of(param.getPage(), param.getLimit(), sorting);
        }

        return pageable;
    }
}
