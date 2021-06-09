package ch.suva.restdata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@EqualsAndHashCode
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    @Embedded
    private KundenportalBenutzer kundenportalBenutzer;
    @OneToMany
    private List<Address> addressList;
    @OneToMany
    private List<Communication> communicationList;
    @JsonIgnore // Hint: Hiding members
    @OneToMany
    private List<Secrets> secretsList;
    
}
