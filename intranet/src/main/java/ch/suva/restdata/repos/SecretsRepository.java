package ch.suva.restdata.repos;

import ch.suva.restdata.entities.Secrets;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "secrets",
    path = "secrets",
    exported = false // Hint: protect repos
)
public interface SecretsRepository extends PagingAndSortingRepository<Secrets, Long> {

}
