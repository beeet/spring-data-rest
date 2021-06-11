package ch.suva.restdata.intranet.listeners;

import ch.suva.restdata.intranet.entities.Address;
import ch.suva.restdata.intranet.entities.Person;
import ch.suva.restdata.intranet.service.PersonServiceStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler // Remark: geht zuerst in den Event Handler und dann auf die Enity#PreRemove
public class EventHandler {
    
    @Autowired
    private PersonServiceStrategyFactory factory;
    
    @HandleBeforeCreate // Remark: für POST
    public void handleBeforeCreateOnPerson(Person person) {
        log.info("HandleBeforeCreate on Person", person);
    }
    
    @HandleBeforeSave // Remark: für PUT und PATCH aber nicht für POST
    public void handleBeforeSaveOnPerson(Person person) {
        log.info("HandleBeforeSave on Person", person);
        
        factory.getInstance(person.getKundenportalBenutzer()).save(person);
    }
    
    @HandleBeforeDelete
    public void handleBeforeDeleteOnPerson(Person person) {
        log.info("HandleBeforeDelete on Person", person);
        
        factory.getInstance(person.getKundenportalBenutzer()).delete(person);
    }
    
    @HandleBeforeSave // Remark: reagiert nie, weil das AddressRepository nicht exponiert ist
    public void handleBeforeSaveOnAddress(Address address) {
        log.info("HandleBeforeSave on Address", address);
    }


//    HandleAfterCreate
//    HandleAfterDelete
//    HandleAfterLinkDelete
//    HandleAfterLinkSave
//    HandleAfterSave
//    HandleBeforeCreate
//    HandleBeforeDelete
//    HandleBeforeLinkDelete
//    HandleBeforeLinkSave
//    HandleBeforeSave
    
}
