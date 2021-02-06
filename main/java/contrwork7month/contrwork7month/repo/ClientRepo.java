package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends CrudRepository<Client, String> {
    List<Client> findAll();
    Optional<Client> findByEmail(String email);
}
