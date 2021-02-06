package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepo extends CrudRepository<Food, String> {
}
