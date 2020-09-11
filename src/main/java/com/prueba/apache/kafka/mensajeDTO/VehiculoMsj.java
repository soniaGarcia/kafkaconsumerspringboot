package com.prueba.apache.kafka.mensajeDTO;

import com.google.gson.GsonBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author sonia.cabrera
 */
public class VehiculoMsj {

    public ObjectId id;
    public Integer puertas;
    public Integer ventanas;
    public Integer llantas;
    public Integer pasajeros;
    public Integer asientos;
    public String descripcion;
    public String color;
    public String marca;
    public String codigo;
    public String precio;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
