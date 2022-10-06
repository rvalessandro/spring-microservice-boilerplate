package com.systeric.springmicroserviceboilerplate.foundation.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BaseResponse {
    String message;
    int statusCode;
}
