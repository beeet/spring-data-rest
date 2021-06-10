package ch.suva.restdata.converter;

import ch.suva.restdata.entities.AddressType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Joiner;

import java.io.IOException;

public class AddressTypeSerializer extends JsonSerializer<AddressType> {
    
    @Override
    public void serialize(AddressType value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeObject(Joiner.on(" ").join(">", value, "<"));
    }
    
}
