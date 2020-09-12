package com.prueba.apache.kafka.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Controlador")
public class Controlador {
    
    @GetMapping("/")
    public String enviarMensaje(@PathVariable String mensaje) {
        String respuesta = "Hola mundo";
        return respuesta;

    }

    

}
