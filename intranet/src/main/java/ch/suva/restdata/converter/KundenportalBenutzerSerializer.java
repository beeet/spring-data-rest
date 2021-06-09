package ch.suva.restdata.converter;

import ch.suva.restdata.entities.Geschlecht;
import ch.suva.restdata.entities.KundenportalBenutzer;
import ch.suva.restdata.entities.Sprache;
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
        jgen.writeStringField("geschlecht", resolveGeschlecht(value.getGeschlecht()));
        jgen.writeStringField("sprache", resolveSprache(value.getSprache()));
    }
    
    private String resolveGeschlecht(Geschlecht geschlecht) {
        switch (geschlecht) {
            case F:
                return "weiblich";
            case M:
            default:
                return "maennlich";
            
        }
    }
    
    private String resolveSprache(Sprache sprache) {
        switch (sprache) {
            case FR:
                return "franzoesisch";
            case IT:
                return "italienisch";
            case EN:
                return "englisch";
            case DE:
            default:
                return "deutsch";
        }
    }
}
