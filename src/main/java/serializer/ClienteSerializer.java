/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import entidades.Cliente;
import java.io.IOException;

/**
 *
 * @author Vastem
 */
public class ClienteSerializer extends JsonSerializer<Cliente>{

    @Override
    public void serialize(Cliente cliente, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", cliente.getId());
        gen.writeStringField("nombre", cliente.getNombre());
        gen.writeStringField("apellido", cliente.getApellido());
        
        // Agregar más campos aquí según sea necesario
        gen.writeEndObject();
    }
    
}
