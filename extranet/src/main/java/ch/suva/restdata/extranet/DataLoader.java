package ch.suva.restdata.extranet;

import ch.suva.restdata.extranet.entities.Address;
import ch.suva.restdata.extranet.entities.AddressType;
import ch.suva.restdata.extranet.entities.Communication;
import ch.suva.restdata.extranet.entities.CommunicationType;
import ch.suva.restdata.extranet.entities.Geschlecht;
import ch.suva.restdata.extranet.entities.KundenportalBenutzer;
import ch.suva.restdata.extranet.entities.Person;
import ch.suva.restdata.extranet.entities.Secrets;
import ch.suva.restdata.extranet.entities.Sprache;
import ch.suva.restdata.extranet.repos.AddressRepository;
import ch.suva.restdata.extranet.repos.CommunicationRepository;
import ch.suva.restdata.extranet.repos.PersonRepository;
import ch.suva.restdata.extranet.repos.SecretsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
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
        KundenportalBenutzer kun = new KundenportalBenutzer("KunVorname", "KunNachname", Geschlecht.M, Sprache.DE);
        setupPerson("John", "Doe", LocalDate.of(1970, 1, 1), kun,
            Arrays.asList(setupAddress(AddressType.PRIVATE, "Obergrundstrasse 65")),
            Arrays.asList(setupCommunication(CommunicationType.MOBILE, "+41 79 511 34 74")),
            Arrays.asList(setupSecrets("geheim")));
        setupPerson("Hans", "Zwei", LocalDate.of(1980, 1, 1), kun,
            Arrays.asList(setupAddress(AddressType.OFFICE, "Luzernstrasse 15")),
            Arrays.asList(setupCommunication(CommunicationType.URL, "www.facebook.com/456")),
            Arrays.asList(setupSecrets("passwort"), setupSecrets("streng geheim")));
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
        return address;
    }
    
    private Communication setupCommunication(CommunicationType type, String content) {
        Communication communication = Communication.builder()
            .type(type)
            .content(content)
            .build();
        return communication;
    }
    
    private Secrets setupSecrets(String secret) {
        Secrets secrets = Secrets.builder()
            .url("www.suva.ch/login")
            .user("sbs@suva.ch")
            .password(secret)
            .build();
        return secrets;
    }
}
