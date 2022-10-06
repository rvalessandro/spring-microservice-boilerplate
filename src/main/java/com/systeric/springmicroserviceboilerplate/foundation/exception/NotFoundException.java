package com.systeric.springmicroserviceboilerplate.foundation.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String id, String name) {
        super(String.format("%s with id %s not found", name, id));
    }
}
