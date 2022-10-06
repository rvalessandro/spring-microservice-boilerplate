package com.systeric.springmicroserviceboilerplate.domain.adapters.users;

import com.google.gson.Gson;
import com.systeric.springmicroserviceboilerplate.domain.models.users.User;
import com.systeric.springmicroserviceboilerplate.domain.services.users.IUserService;
import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.EventNameConstants;
import com.systeric.springmicroserviceboilerplate.foundation.exception.NotFoundException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class UserConsumerAdapter implements IUserConsumerAdapter {
    private final Gson gson;
    private IUserService userService;

    @Override
    public void onConsumerTopicUser(ConsumerRecord<String, String> cr) throws ValidationException, NotFoundException {
        EventObject eventObject = gson.fromJson(String.valueOf(cr.value()), EventObject.class);

        User user = gson.fromJson(gson.toJson(eventObject.payload), User.class);

        switch (eventObject.getEventName()) {
            case EventNameConstants.USER_CREATED:
                userService.createUser(user);
                break;
            case EventNameConstants.USER_UPDATED:
                userService.updateUser(user);
                break;
        }
    }
}