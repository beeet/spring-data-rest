package ch.suva.restdata.repos;

import ch.suva.restdata.entities.Communication;
import ch.suva.restdata.entities.CommunicationType;
import ch.suva.restdata.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "communication",
    path = "communication",
    exported = false // Hint: protect repos
)
public interface CommunicationRepository extends PagingAndSortingRepository<Communication, Long> {
    
    List<Person> findByType(@Param("type") CommunicationType type);
    
}
