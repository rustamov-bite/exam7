package contrwork7month.contrwork7month.dto;

import contrwork7month.contrwork7month.models.Food;
import lombok.*;
import org.springframework.data.domain.Page;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodDto {
    public static FoodDto from(Food food) {
        return FoodDto.builder()
                .id(food.getId())
                .name(food.getName())
                .type(food.getType())
                .price(food.getPrice())
                .build();
    }

    public static Page<FoodDto> fromList(Page<Food> foods) {
        return foods.map(FoodDto::from);
    }

    private String id;
    private String name;
    private String type;
    private double price;
}
