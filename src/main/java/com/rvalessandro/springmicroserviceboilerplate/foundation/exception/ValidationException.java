package com.rvalessandro.springmicroserviceboilerplate.foundation.exception;

public class ValidationException extends Exception {
    public ValidationException(String msg) {
        super(msg);
    }
}
