package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.constant.TopicConstants;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements IProducer {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger logger = LogManager.getLogger(Producer.class);

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean publish(EventObject object) throws Exception {
        String message = objectMapper.writeValueAsString(object);

        kafkaTemplate.send(TopicConstants.USER, object.getEventName(), message);

        logger.info("Success Publish Topic: {} with value {}", TopicConstants.USER, message);

        return true;
    }
}
