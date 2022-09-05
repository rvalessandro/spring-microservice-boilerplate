package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers;

public interface IProducer {
    boolean publish(String eventName, Object payload) throws Exception;

}
