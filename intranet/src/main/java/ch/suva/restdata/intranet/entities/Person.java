package ch.suva.restdata.intranet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import java.time.LocalDate;
import java.util.List;

@Slf4j
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
    
    @JsonUnwrapped // Remark: deserialized on person level
    private Title title;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    @Embedded
    private KundenportalBenutzer kundenportalBenutzer;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addressList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Communication> communicationList;
    @JsonIgnore // Remark:  Hiding members
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Secrets> secretsList;
    
    @PreRemove
    public void preRemove() {
        log.info("PreRemove on Person");
    }
}
