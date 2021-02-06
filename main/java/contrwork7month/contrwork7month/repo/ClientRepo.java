package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, String> {

}
