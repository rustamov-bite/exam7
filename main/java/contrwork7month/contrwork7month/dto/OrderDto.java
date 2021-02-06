package contrwork7month.contrwork7month.dto;

import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.models.Food;
import contrwork7month.contrwork7month.models.Order;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDto {
    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .client(order.getClient())
                .food(order.getFood())
                .localDate(order.getLocalDate())
                .build();
    }

    private Client client;
    private Food food;
    private LocalDate localDate;
}
