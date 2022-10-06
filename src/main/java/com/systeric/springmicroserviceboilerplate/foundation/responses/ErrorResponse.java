package com.systeric.springmicroserviceboilerplate.foundation.responses;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse extends BaseResponse {
    public ErrorResponse(String message, HttpStatus statusCode) {
        super(message, statusCode.value());
    }
}
