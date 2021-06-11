package ch.suva.restdata.intranet.repos;

import ch.suva.restdata.intranet.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Secured("ROLE_USER") Remark: security check on class und method level
@RepositoryRestResource(
    collectionResourceRel = "people",
    path = "people" // Remark:  custom relation naming
)
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    // @Secured("ROLE_USER")
    List<Person> findByLastName(@Param("lastName") String lastName);
    
    // @Secured("ROLE_USER")
    List<Person> findByFirstName(@Param("firstName") String firstName);
    
    // @Secured("ROLE_USER")
    @RestResource(path = "lastNameStartsWith", rel = "lastNameStartsWith")
    Page findByLastNameStartsWith(@Param("lastName") String lastName, Pageable p); // Remark:  override default
    
    // @Secured("ROLE_ADMIN")
    @Transactional
    List<Person> deleteByFirstName(@Param("firstName") String firstName); // TODO does not work!?!
    
}
