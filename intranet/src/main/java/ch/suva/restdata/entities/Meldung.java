package ch.suva.restdata.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@EqualsAndHashCode
public class Meldung {
    private Integer meldungsTyp;
    
    private String meldungsCode;
    
    private UUID meldungsId;
    
    private String message;
    
}

