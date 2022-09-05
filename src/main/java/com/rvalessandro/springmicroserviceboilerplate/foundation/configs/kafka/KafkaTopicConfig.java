package com.rvalessandro.springmicroserviceboilerplate.foundation.configs.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicUser() {
        return TopicBuilder
                .name("user")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
