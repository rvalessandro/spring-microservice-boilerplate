package com.systeric.springmicroserviceboilerplate.application.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.systeric.springmicroserviceboilerplate.domain.adapters.users.IUserConsumerAdapter;
import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.TopicConstants;
import com.systeric.springmicroserviceboilerplate.foundation.configs.data.TenantAwareThread;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConsumer {
    private final IUserConsumerAdapter userConsumerAdapter;
    private Gson gson;

    @KafkaListener(topics = TopicConstants.USER)
    public void listener(ConsumerRecord<String, String> cr) throws ValidationException, JsonProcessingException, NotFoundException {
        EventObject eventObject = gson.fromJson(String.valueOf(cr.value()), EventObject.class);

        String tenantID = eventObject.getContext().getTenantId();
        new TenantAwareThread(() -> {
            try {
                userConsumerAdapter.onConsumerTopicUser(cr);
            } catch (ValidationException | JsonProcessingException | NotFoundException e) {
                e.printStackTrace();
            }
        }, tenantID).start();
    }
}
