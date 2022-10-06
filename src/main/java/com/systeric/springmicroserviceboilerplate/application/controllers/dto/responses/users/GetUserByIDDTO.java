package com.systeric.springmicroserviceboilerplate.application.controllers.dto.responses.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetUserByIDDTO {
    private String id;
    private String name;
}
