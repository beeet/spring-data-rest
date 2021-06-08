package ch.suva.restdata.entities;

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
public class KundenportalBenutzer {
    
    private String vorname;
    private String nachname;
    @Enumerated(EnumType.STRING)
    private Geschlecht geschlecht;
    @Enumerated(EnumType.STRING)
    private Sprache sprache;
    
}
