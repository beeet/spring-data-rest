package ch.suva.restdata.intranet.repos;

import ch.suva.restdata.intranet.entities.Communication;
import ch.suva.restdata.intranet.entities.CommunicationType;
import ch.suva.restdata.intranet.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "communication",
    path = "communication",
    exported = false // Remark:  protect repos
)
public interface CommunicationRepository extends PagingAndSortingRepository<Communication, Long> {
    
    List<Person> findByType(@Param("type") CommunicationType type);
    
}
