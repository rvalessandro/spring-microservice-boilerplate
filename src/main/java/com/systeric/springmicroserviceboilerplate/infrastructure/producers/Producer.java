package com.systeric.springmicroserviceboilerplate.infrastructure.producers;

import com.google.gson.Gson;
import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.TopicConstants;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements IProducer {
    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, Gson gson) {
        this.kafkaTemplate = kafkaTemplate;
        this.gson = gson;
    }

    @Override
    public void publish(EventObject object) throws ValidationException {
        if (object == null) throw new ValidationException("Event Object can't be null");
        String message = gson.toJson(object);
        kafkaTemplate.send(TopicConstants.USER, object.getEventName(), message);
    }
}
