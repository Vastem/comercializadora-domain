/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import entidades.Cliente;
import entidades.Pedido;
import java.io.IOException;

/**
 *
 * @author Vastem
 */
public class PedidoSerializer extends JsonSerializer<Pedido>{

    @Override
    public void serialize(Pedido pedido, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", pedido.getId());
        
        // Agregar más campos aquí según sea necesario
        gen.writeEndObject();
    }
    
}
