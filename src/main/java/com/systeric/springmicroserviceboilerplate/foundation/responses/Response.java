package com.systeric.springmicroserviceboilerplate.foundation.responses;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> extends BaseResponse {
    T data;

    public Response(T data) {
        super("Success", HttpStatus.OK.value());
        this.data = data;
    }
}
