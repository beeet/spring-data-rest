package ch.suva.restdata.intranet.service.internal;

import ch.suva.restdata.intranet.entities.Person;
import ch.suva.restdata.intranet.service.PersonServiceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PersonServiceImpl implements PersonServiceStrategy {
    
    public PersonServiceImpl() {
        log.info("create PersonService");
    }
    
    @Override
    public void save(Person person) {
        log.info("save: do something");
        if (person.getAddressList().isEmpty()) {
            doThis();
        } else {
            doThat();
        }
    }
    
    private void doThis() {
        log.info("do this");
    }
    
    private void doThat() {
        log.info("do that");
    }
    
    @Override
    public void delete(Person person) {
        log.info("delete: do something");
    }
}
