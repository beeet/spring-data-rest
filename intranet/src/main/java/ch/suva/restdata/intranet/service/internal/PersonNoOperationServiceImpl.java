package ch.suva.restdata.intranet.service.internal;

import ch.suva.restdata.intranet.entities.Person;
import ch.suva.restdata.intranet.service.PersonServiceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PersonNoOperationServiceImpl implements PersonServiceStrategy {
    
    public PersonNoOperationServiceImpl() {
        log.info("create NoOperationService");
    }
    
    @Override
    public void save(Person person) {
        log.info("save: do nothing");
    }
    
    @Override
    public void delete(Person person) {
        log.info("delete: do nothing");
    }
}
