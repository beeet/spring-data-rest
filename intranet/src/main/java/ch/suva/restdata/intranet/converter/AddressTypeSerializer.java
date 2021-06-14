package ch.suva.restdata.intranet.converter;

import ch.suva.restdata.intranet.entities.AddressType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Joiner;
import lombok.SneakyThrows;

public class AddressTypeSerializer extends JsonSerializer<AddressType> {
    
    @SneakyThrows
    @Override
    public void serialize(AddressType value, JsonGenerator jgen, SerializerProvider provider) {
        jgen.writeObject(Joiner.on(" ").join(">", value, "<"));
    }
    
}
