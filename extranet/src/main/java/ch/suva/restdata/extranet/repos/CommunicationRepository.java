package ch.suva.restdata.extranet.repos;

import ch.suva.restdata.extranet.entities.Communication;
import ch.suva.restdata.extranet.entities.CommunicationType;
import ch.suva.restdata.extranet.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "communication",
    path = "communication"
)
public interface CommunicationRepository extends PagingAndSortingRepository<Communication, Long> {
    
    List<Person> findByType(@Param("type") CommunicationType type);
    
}
