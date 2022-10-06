package com.systeric.springmicroserviceboilerplate.foundation.interceptors;

import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.foundation.responses.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomControllerAdvice {
    private static final Logger logger = LogManager.getLogger(CustomControllerAdvice.class);

    @ExceptionHandler({NotFoundException.class, ValidationException.class})
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(
            Exception e) {
        logger.error(e.getMessage(), e);

        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), status), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception e) {
        String msg = "Unhandled Error";
        logger.error(msg, e);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse(msg, status), status);
    }
}