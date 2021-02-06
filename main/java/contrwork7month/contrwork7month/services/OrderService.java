package contrwork7month.contrwork7month.services;

import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.models.Food;
import contrwork7month.contrwork7month.models.Order;
import contrwork7month.contrwork7month.repo.FoodRepo;
import contrwork7month.contrwork7month.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final FoodRepo foodRepo;

    public void addOrder(Client client, String foodId) {
        Order order = Order.builder()
                .client(client)
                .food(getFood(foodId))
                .localDate(LocalDate.now())
                .build();
        orderRepo.save(order);
    }

    private Food getFood(String foodId) {
        Optional<Food> food = foodRepo.findById(foodId);
        if (food.isPresent()) {
            return food.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Order> getClientOrders(Client client) {
        return orderRepo.findAllByClient(client);
    }
}
