package contrwork7month.contrwork7month.services;

import contrwork7month.contrwork7month.models.Caffee;
import contrwork7month.contrwork7month.models.Food;
import contrwork7month.contrwork7month.repo.CaffeeRepo;
import contrwork7month.contrwork7month.repo.FoodRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodService {
    private final FoodRepo foodRepo;
    private final CaffeeRepo caffeeRepo;

    public Page<Food> getFoodOfCaffee(String caffeeId, Pageable pageable) {
        return foodRepo.findFoodsByCaffee(getCaffee(caffeeId), pageable);
    }

    public boolean existsFoodById(String foodId) {
        return foodRepo.existsById(foodId);
    }

    private Caffee getCaffee(String caffeeId) {
        Caffee caffee;
        if (caffeeRepo.findById(caffeeId).isPresent()) {
            caffee = caffeeRepo.findById(caffeeId).get();
        } else {
            throw new IllegalArgumentException();
        }
        return caffee;
    }
}
