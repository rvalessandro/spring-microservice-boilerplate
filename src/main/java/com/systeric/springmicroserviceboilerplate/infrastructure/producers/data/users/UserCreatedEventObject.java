package com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.users;

import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.EventNameConstants;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.Context;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;

public class UserCreatedEventObject extends EventObject {
    public UserCreatedEventObject(Object payload) {
        this.eventName = EventNameConstants.USER_CREATED;
        this.context = new Context();
        this.payload = payload;
    }
}
