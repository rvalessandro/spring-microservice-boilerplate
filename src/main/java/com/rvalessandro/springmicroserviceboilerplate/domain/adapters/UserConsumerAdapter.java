package com.rvalessandro.springmicroserviceboilerplate.domain.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.IUserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumerAdapter {
    private final String userTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private static final Logger logger = LogManager.getLogger(UserConsumerAdapter.class);
    private final IUserService userService;

    @Autowired
    public UserConsumerAdapter(ObjectMapper objectMapper, IUserService userService) {
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @KafkaListener(topics = "user")
    public void listener(ConsumerRecord<String, String> cr) throws Exception {
        logger.info("Success Consume topic: {} with value {}", cr.topic(), cr.value());

        JsonNode node = objectMapper.readValue(cr.value(), JsonNode.class);
        String userName = node.get("name").get("value").asText();

        userService.createUser(new User(new Name(userName)));
    }
}
