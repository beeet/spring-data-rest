package ch.suva.restdata.intranet.service.internal;

import ch.suva.restdata.intranet.entities.Geschlecht;
import ch.suva.restdata.intranet.entities.KundenportalBenutzer;
import ch.suva.restdata.intranet.service.PersonServiceStrategy;
import ch.suva.restdata.intranet.service.PersonServiceStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PersonServiceStrategyFactoryImpl implements PersonServiceStrategyFactory {
    
    @Autowired
    private BeanFactory beanFactory;
    
    public PersonServiceStrategy getInstance(KundenportalBenutzer benutzer) {
        if (Geschlecht.M.equals(benutzer.getGeschlecht())) {
            return beanFactory.getBean(PersonServiceImpl.class);
        } else {
            return beanFactory.getBean(PersonNoOperationServiceImpl.class);
        }
    }
    
}
