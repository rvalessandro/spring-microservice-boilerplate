package com.systeric.springmicroserviceboilerplate.domain.adapters.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IUserConsumerAdapter {
    void onConsumerTopicUser(ConsumerRecord<String, String> cr) throws ValidationException, JsonProcessingException, NotFoundException;
}
