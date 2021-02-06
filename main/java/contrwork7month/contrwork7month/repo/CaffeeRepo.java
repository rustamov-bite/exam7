package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Caffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaffeeRepo extends CrudRepository<Caffee, String> {
    Page<Caffee> findAll(Pageable pageable);
}
