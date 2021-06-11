package ch.suva.restdata.intranet.service;

import ch.suva.restdata.intranet.entities.KundenportalBenutzer;

public interface PersonServiceStrategyFactory {
    
    PersonServiceStrategy getInstance(KundenportalBenutzer benutzer);
    
}
