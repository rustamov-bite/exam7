package contrwork7month.contrwork7month.dto;

import contrwork7month.contrwork7month.models.Food;
import lombok.*;

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

    private String id;
    private String name;
    private String type;
    private double price;
}
