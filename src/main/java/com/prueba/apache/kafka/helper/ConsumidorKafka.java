package com.prueba.apache.kafka.helper;

import com.prueba.apache.kafka.mensajeDTO.VehiculoMsj;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorKafka {

    @KafkaListener(topics = "test", groupId = "foo", containerFactory = "vehiculoKafkaListenerContainerFactory")
    public void listenTest(VehiculoMsj message) {
        System.out.println("Received Message in group foo: " + message.marca);
    }

}
