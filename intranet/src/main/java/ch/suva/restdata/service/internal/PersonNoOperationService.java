package ch.suva.restdata.service.internal;

import ch.suva.restdata.service.PersonServiceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PersonNoOperationService implements PersonServiceStrategy {
    
    public PersonNoOperationService() {
        log.info("create NoOperationService");
    }
    
    @Override
    public void execute() {
        log.info("doSomething");
    }
}
