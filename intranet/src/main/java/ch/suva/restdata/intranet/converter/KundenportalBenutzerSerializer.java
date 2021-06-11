package ch.suva.restdata.intranet.converter;

import ch.suva.restdata.intranet.entities.KundenportalBenutzer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Joiner;

import java.io.IOException;

public class KundenportalBenutzerSerializer extends JsonSerializer<KundenportalBenutzer> {
    
    @Override
    public void serialize(KundenportalBenutzer value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStringField("name:", Joiner.on(" ").skipNulls()
            .join(value.getNachname(), value.getVorname()));
        jgen.writeObjectField("geschlecht", value.getGeschlecht());
        jgen.writeObjectField("sprache", value.getSprache());
    }
}
