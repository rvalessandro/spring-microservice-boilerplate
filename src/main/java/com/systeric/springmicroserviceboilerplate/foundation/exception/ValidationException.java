package com.systeric.springmicroserviceboilerplate.foundation.exception;

public class ValidationException extends Exception {
    public ValidationException(String field) {
        super(String.format("Validation Error: %s", field));
    }
}
