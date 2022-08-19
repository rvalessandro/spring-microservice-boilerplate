package com.rvalessandro.springmicroserviceboilerplate.domain.models;

import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private Name name;
}
