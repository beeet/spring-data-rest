package ch.suva.restdata.intranet.repos;

import ch.suva.restdata.intranet.entities.Address;
import ch.suva.restdata.intranet.entities.AddressType;
import ch.suva.restdata.intranet.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "address",
    path = "address",
    exported = false // Remark:  protect repos
)
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    
    List<Person> findByAddressType(@Param("type") AddressType addressType);
}
