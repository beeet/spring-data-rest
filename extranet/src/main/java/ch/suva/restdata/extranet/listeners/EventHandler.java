package ch.suva.restdata.extranet.listeners;

import ch.suva.restdata.extranet.entities.Address;
import ch.suva.restdata.extranet.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler // Remark: geht zuerst in den Event Handler und dann auf die Enity#PreRemove
public class EventHandler {
    
    @HandleBeforeSave // Remark: für PUT und PATCH aber nicht für POST
    public void handleBeforeSaveOnPerson(Person person) {
        log.info("HandleBeforeCreate on Person", person);
    }
    
    @HandleBeforeSave
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
