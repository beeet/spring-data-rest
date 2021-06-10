package ch.suva.restdata.service.internal;

import ch.suva.restdata.service.PersonServiceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PersonService implements PersonServiceStrategy {
    
    public PersonService() {
        log.info("create PersonService");
    }
    
    @Override
    public void execute() {
        log.info("do something");
    }
}
