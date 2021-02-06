package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, String> {
}
