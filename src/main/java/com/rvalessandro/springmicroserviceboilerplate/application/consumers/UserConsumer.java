package com.rvalessandro.springmicroserviceboilerplate.application.consumers;

import com.rvalessandro.springmicroserviceboilerplate.domain.adapters.UserConsumerAdapter;
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

    @KafkaListener(topics = "user")
    public void listener(ConsumerRecord<String, String> cr) {
        try {
            logger.info("Success Consume topic: {} with value {}", cr.topic(), cr.value());
            userConsumerAdapter.createUser(cr);
        } catch (Exception e) {
            logger.error("Unable to consume", e);
        }
    }
}
