package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data;

import com.rvalessandro.springmicroserviceboilerplate.foundation.configs.constant.EventNameConstants;

public class UserCreatedEventObject extends EventObject {
    public UserCreatedEventObject(Object payload) {
        this.eventName = EventNameConstants.USERCREATED;
        this.context = new Context();
        this.payload = payload;
    }
}
