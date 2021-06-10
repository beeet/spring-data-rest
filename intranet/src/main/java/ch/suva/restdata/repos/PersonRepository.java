package ch.suva.restdata.repos;

import ch.suva.restdata.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "people",
    path = "people" // Remark:  custom relation naming
)
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    List<Person> findByLastName(@Param("lastName") String lastName);
    
    List<Person> findByFirstName(@Param("firstName") String firstName);
    
    @RestResource(path = "lastNameStartsWith", rel = "lastNameStartsWith")
    Page findByLastNameStartsWith(@Param("lastName") String lastName, Pageable p); // Remark:  override default
    
    @Transactional
    List<Person> deleteByFirstName(@Param("firstName") String firstName); // TODO does not work!?!
    
}
