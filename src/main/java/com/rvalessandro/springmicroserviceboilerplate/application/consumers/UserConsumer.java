package com.rvalessandro.springmicroserviceboilerplate.application.consumers;

import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserConsumerAdapter;
import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.constant.TopicConstants;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConsumer {
    private static final Logger logger = LogManager.getLogger(UserConsumer.class);
    private final UserConsumerAdapter userConsumerAdapter;

    @KafkaListener(topics = TopicConstants.USER)
    public void listener(ConsumerRecord<String, String> cr) {
        try {
            logger.info("Success Consume topic: {} with event name {}", cr.topic(), cr.key());
            userConsumerAdapter.createUser(cr);
        } catch (Exception e) {
            logger.error("Unable to Consume topic: {} with event name {}", cr.topic(), cr.key(), e);
        }
    }
}
