package contrwork7month.contrwork7month.dto;

import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.models.Food;
import contrwork7month.contrwork7month.models.Order;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public static List<OrderDto> fromList(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(from(order));
        }
        return orderDtos;
    }

    private Client client;
    private Food food;
    private LocalDate localDate;
}
