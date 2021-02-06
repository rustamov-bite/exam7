package contrwork7month.contrwork7month.controllers;

import contrwork7month.contrwork7month.dto.OrderDto;
import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.services.FoodService;
import contrwork7month.contrwork7month.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final FoodService foodService;
    @PostMapping("/order")
    public ResponseEntity<Void> orderFood(Authentication authentication,
                                          @RequestParam("foodId") String foodId) {
        Client client = (Client) authentication.getPrincipal();
        if (foodService.existsFoodById(foodId)) {
            orderService.addOrder(client, foodId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientOrders")
    public List<OrderDto> getOrders(Authentication authentication) {
        Client client = (Client) authentication.getPrincipal();
        return OrderDto.fromList(orderService.getClientOrders(client));
    }
}
