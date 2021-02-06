package contrwork7month.contrwork7month.repo;

import contrwork7month.contrwork7month.models.Caffee;
import contrwork7month.contrwork7month.models.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends CrudRepository<Food, String> {
    List<Food> findAll();
    Page<Food> findFoodsByCaffee(Caffee caffee, Pageable pageable);
    boolean existsById(String foodId);
}
