package ch.suva.restdata.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@EqualsAndHashCode
@Embeddable
@Access(AccessType.FIELD)
public class Title {
    
    private String title;
    @JsonInclude(JsonInclude.Include.NON_EMPTY) // Remark: exclude in json
    private String academicTitle;
    
}
