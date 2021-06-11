package ch.suva.restdata.intranet.repos;

import ch.suva.restdata.intranet.entities.Secrets;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "secrets",
    path = "secrets",
    exported = false // Remark:  protect repos
)
public interface SecretsRepository extends PagingAndSortingRepository<Secrets, Long> {

}
