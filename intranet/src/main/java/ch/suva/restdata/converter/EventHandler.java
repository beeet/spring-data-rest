package ch.suva.restdata.converter;

import ch.suva.restdata.entities.Address;
import ch.suva.restdata.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler
public class EventHandler {
    
    @HandleBeforeDelete // Remark: geht zuerst in den Event Handler und dann auf die Enity#PreRemove
    public void handleBeforeDeleteOnPerson(Person person) {
        log.info("HandleBeforeDelete on Person", person);
    }
    
    @HandleBeforeDelete
    public void handleBeforeDeleteOnAddress(Address address) {
        log.info("HandleBeforeDelete on Address", address);
    }
    
    // BeforeLinkSaveEvent
    // BeforeDeleteEvent
    // BeforeSaveEvent,
    // AfterCreateEvent
    // AfterSaveEvent
    // AfterDeleteEvent
    // AfterLinkSaveEvent
    
}
