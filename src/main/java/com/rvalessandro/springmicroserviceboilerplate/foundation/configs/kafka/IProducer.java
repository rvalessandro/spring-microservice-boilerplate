package com.rvalessandro.springmicroserviceboilerplate.foundation.configs.kafka;

public interface IProducer {

    boolean publish(String topic, Object object) throws Exception;

}
