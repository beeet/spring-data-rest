package ch.suva.restdata.intranet.service;

import ch.suva.restdata.intranet.entities.Person;

public interface PersonServiceStrategy {
    
    void save(Person person);
    
    void delete(Person person);
    
}
