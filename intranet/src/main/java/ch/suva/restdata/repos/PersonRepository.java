package ch.suva.restdata.repos;

import ch.suva.restdata.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "people",
    path = "people" // Requirement: custom relation naming
)
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    
    List<Person> findByLastName(@Param("lastName") String lastName);
    
    List<Person> findByFirstName(@Param("firstName") String firstName);
    
    @RestResource(path = "lastNameStartsWith", rel = "lastNameStartsWith")
    Page findByLastNameStartsWith(@Param("lastName") String lastName, Pageable p); // Requirement: override default
    
}
