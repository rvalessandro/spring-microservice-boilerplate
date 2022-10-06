package com.systeric.springmicroserviceboilerplate.foundation.exception;

public class KafkaPublishException extends Exception {
    public KafkaPublishException(String message) {
        super(String.format("Unable to publish event with payload: %s", message));
    }
}
