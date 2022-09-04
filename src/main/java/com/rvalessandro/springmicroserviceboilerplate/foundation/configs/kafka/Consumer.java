package com.rvalessandro.springmicroserviceboilerplate.foundation.configs.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.infrastructure.adapters.UserServiceRepositoryAdapter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final String userTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private static final Logger logger = LogManager.getLogger(Consumer.class);
    private final UserServiceRepositoryAdapter userServiceRepositoryAdapter;

    @Autowired
    public Consumer(ObjectMapper objectMapper, UserServiceRepositoryAdapter userServiceRepositoryAdapter) {
        this.objectMapper = objectMapper;
        this.userServiceRepositoryAdapter = userServiceRepositoryAdapter;
    }

    // TODO: need to be modify
    @KafkaListener(topics = "user")
    public void listener(ConsumerRecord<String, String> cr) throws Exception {
        logger.info(cr.value());
        logger.info("Success Consume topic: {}", cr.topic());

        JsonNode node = objectMapper.readValue(cr.value(), JsonNode.class);
        String userName = node.get("name").get("value").asText();

        userServiceRepositoryAdapter.createUser(new User(new Name(userName)));
    }
}
