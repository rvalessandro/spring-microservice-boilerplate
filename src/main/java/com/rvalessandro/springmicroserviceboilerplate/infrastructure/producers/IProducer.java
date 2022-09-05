package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers;

import com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;

public interface IProducer {
    boolean publish(EventObject object) throws Exception;

}
