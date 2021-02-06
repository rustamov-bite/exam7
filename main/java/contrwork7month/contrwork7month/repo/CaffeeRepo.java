package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Caffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaffeeRepo extends CrudRepository<Caffee, String> {
}
