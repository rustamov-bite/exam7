package contrwork7month.contrwork7month.controllers;

import contrwork7month.contrwork7month.dto.FoodDto;
import contrwork7month.contrwork7month.services.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/caffeeFoods/{caffeeId}")
    public Page<FoodDto> getFoodOfCaffee(@PathVariable("caffeeId") String caffeeId,
                                         Pageable pageable) {
        return FoodDto.fromList(foodService.getFoodOfCaffee(caffeeId, pageable));
    }
}
