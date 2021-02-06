package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, String> {
    List<Order> findAllByClient(Client client);
}
