package com.systeric.springmicroserviceboilerplate.foundation.configs.kafka;

import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.TopicConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicUser() {
        return TopicBuilder
                .name(TopicConstants.USER)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
