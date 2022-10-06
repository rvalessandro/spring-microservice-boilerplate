package com.systeric.springmicroserviceboilerplate.foundation.interceptors;

import com.google.gson.Gson;
import com.systeric.springmicroserviceboilerplate.infrastructure.producers.data.EventObject;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class KafkaConsumerInterceptor implements ConsumerInterceptor<String, String> {

    private static final Logger logger = LogManager.getLogger(KafkaConsumerInterceptor.class);
    private Gson gson;

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        for (ConsumerRecord<String, String> cr : records) {
            try {
                EventObject eventObject = gson.fromJson(String.valueOf(cr.value()), EventObject.class);

                String tenantID = eventObject.getContext().getTenantId();
            } catch (Exception e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        return records;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
    }

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> configs) {
        gson = new Gson();
    }
}
