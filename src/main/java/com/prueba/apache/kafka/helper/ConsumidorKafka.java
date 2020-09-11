package com.prueba.apache.kafka.helper;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorKafka {

    @KafkaListener(topics = "test", groupId = "foo")
    public void listenTest(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

}
