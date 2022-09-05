package com.rvalessandro.springmicroserviceboilerplate.domain.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.User;
import com.rvalessandro.springmicroserviceboilerplate.domain.models.vo.Name;
import com.rvalessandro.springmicroserviceboilerplate.domain.services.IUserService;
import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.constant.EventNameConstant;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class UserConsumerAdapter {
    private IUserService userService;
    private final ObjectMapper objectMapper;

    public void createUser(ConsumerRecord<String, String> cr) throws Exception {
        JsonNode node = objectMapper.readValue(cr.value(), JsonNode.class);

        String eventName = node.get("eventName").asText();
        String userName = node.get("payload").get("name").get("value").asText();

        switch (eventName) {
            case EventNameConstant.userCreated:
                User user = new User(new Name(userName));
                userService.createUserByKafka(user);
                break;
        }
    }
}
