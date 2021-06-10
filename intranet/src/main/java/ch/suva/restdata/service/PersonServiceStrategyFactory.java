package ch.suva.restdata.service;

import ch.suva.restdata.entities.KundenportalBenutzer;

public interface PersonServiceStrategyFactory {
    
    PersonServiceStrategy getInstance(KundenportalBenutzer benutzer);
    
}
