package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data;

import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.constant.EventNameConstant;

public class UserCreatedEventObject extends EventObject {
    public UserCreatedEventObject(Object payload) {
        this.eventName = EventNameConstant.userCreated;
        this.context = "";
        this.payload = payload;
    }
}
