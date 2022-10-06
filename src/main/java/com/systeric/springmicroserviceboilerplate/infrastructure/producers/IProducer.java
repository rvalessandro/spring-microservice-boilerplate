package com.systeric.springmicroserviceboilerplate.infrastructure.producers;

import com.systeric.springmicroserviceboilerplate.foundation.exception.KafkaPublishException;
import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;

public interface IProducer {
    void publish(EventObject object) throws KafkaPublishException, ValidationException;

}
