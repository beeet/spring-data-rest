package ch.suva.restdata.intranet.entities;

import ch.suva.restdata.intranet.converter.KundenportalBenutzerSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Access(AccessType.FIELD)
@JsonSerialize(using = KundenportalBenutzerSerializer.class) // Remark:  custom converter
public class KundenportalBenutzer {
    
    private String vorname;
    private String nachname;
    @Enumerated(EnumType.STRING)
    private Geschlecht geschlecht;
    @Enumerated(EnumType.STRING)
    private Sprache sprache;
    
}
