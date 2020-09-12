package com.prueba.apache.kafka.helper;

import com.prueba.apache.kafka.mensajeDTO.VehiculoMsj;
import com.prueba.apache.kafka.model.Inventario;
import com.prueba.apache.kafka.model.QInventario;
import com.prueba.apache.kafka.repository.InventarioRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorKafka {

    @Autowired
    InventarioRepository inventarioRepository;

    @KafkaListener(topics = "test", groupId = "foo", containerFactory = "vehiculoKafkaListenerContainerFactory")
    public void listenTest(VehiculoMsj message) {
        BooleanExpression bol = QInventario.inventario.codigo.eq(message.codigo);
        Optional<Inventario> inv = inventarioRepository.findOne(bol);
        if (inv.isPresent()) {
            Inventario obtenido = inv.get();
            if (obtenido.id != null) {
                obtenido.cantidad = obtenido.cantidad + 1;
                inventarioRepository.save(obtenido);
            }
        } else {
            Inventario persisInv = new Inventario();
            persisInv.cantidad = 1;
            persisInv.codigo = message.codigo;
            persisInv.precio = message.precio;
            inventarioRepository.save(persisInv);
        }

        System.out.println("Received Message in group foo: " + message.marca);
    }

}
