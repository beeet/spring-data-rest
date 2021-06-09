package ch.suva.restdata;

import ch.suva.restdata.entities.Address;
import ch.suva.restdata.entities.AddressType;
import ch.suva.restdata.entities.Communication;
import ch.suva.restdata.entities.CommunicationType;
import ch.suva.restdata.entities.Geschlecht;
import ch.suva.restdata.entities.KundenportalBenutzer;
import ch.suva.restdata.entities.Person;
import ch.suva.restdata.entities.Secrets;
import ch.suva.restdata.entities.Sprache;
import ch.suva.restdata.repos.AddressRepository;
import ch.suva.restdata.repos.CommunicationRepository;
import ch.suva.restdata.repos.PersonRepository;
import ch.suva.restdata.repos.SecretsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DataLoader {
    
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CommunicationRepository communicationRepository;
    @Autowired
    SecretsRepository secretsRepository;
    
    public void setup() {
        addressRepository.deleteAll();
        personRepository.deleteAll();
        KundenportalBenutzer kun = new KundenportalBenutzer("Sepp", "Portaluser", Geschlecht.M, Sprache.DE);
        setupPerson("John", "Doe", LocalDate.of(1970, 1, 1), kun,
            Arrays.asList(setupAddress(AddressType.PRIVATE, "Obergrundstrasse 65")),
            Arrays.asList(setupCommunication(CommunicationType.MOBILE, "+41 79 511 34 74")),
            Arrays.asList(setupSecrets("geheim")));
        setupPerson("Hans", "Zwei", LocalDate.of(1980, 1, 1), kun,
            Arrays.asList(setupAddress(AddressType.OFFICE, "Luzernstrasse 15")),
            Arrays.asList(setupCommunication(CommunicationType.URL, "www.facebook.com/456")),
            Arrays.asList(setupSecrets("passwort"), setupSecrets("streng geheim")));
        
        setupPerson("Adam", "Meier", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Beat", "Meierhans", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Christian", "Meister", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Dominik", "Meiermueller", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Emil", "Meierhuber", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Fritz", "Meiereier", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
        setupPerson("Geri", "Meierkobler", LocalDate.of(1980, 1, 1), kun,
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList());
     
    }
    
    
    private Person setupPerson(String first, String last, LocalDate birth, KundenportalBenutzer kun,
                               List<Address> addressList,
                               List<Communication> comList,
                               List<Secrets> secretsList) {
        Person person = Person.builder()
            .firstName(first)
            .lastName(last)
            .birthday(birth)
            .kundenportalBenutzer(kun)
            .addressList(addressList)
            .communicationList(comList)
            .secretsList(secretsList)
            .build();
        personRepository.save(person);
        return person;
    }
    
    private Address setupAddress(AddressType addressType, String street) {
        Address address = Address.builder()
            .addressType(addressType)
            .street(street)
            .build();
        addressRepository.save(address);
        return address;
    }
    
    private Communication setupCommunication(CommunicationType type, String content) {
        Communication communication = Communication.builder()
            .type(type)
            .content(content)
            .build();
        communicationRepository.save(communication);
        return communication;
    }
    
    private Secrets setupSecrets(String secret) {
        Secrets secrets = Secrets.builder()
            .text(secret)
            .build();
        secretsRepository.save(secrets);
        return secrets;
    }
}
