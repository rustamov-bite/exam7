package contrwork7month.contrwork7month.utils;


import contrwork7month.contrwork7month.confg.SecurityConfig;
import contrwork7month.contrwork7month.models.Caffee;
import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.models.Food;
import contrwork7month.contrwork7month.models.Order;
import contrwork7month.contrwork7month.repo.CaffeeRepo;
import contrwork7month.contrwork7month.repo.ClientRepo;
import contrwork7month.contrwork7month.repo.FoodRepo;
import contrwork7month.contrwork7month.repo.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Configuration
public class InitDatabase {
    private final ClientRepo clientRepo;
    private final FoodRepo foodRepo;
    private final CaffeeRepo caffeeRepo;
    private final OrderRepo orderRepo;

    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
            clientRepo.deleteAll();
            foodRepo.deleteAll();
            caffeeRepo.deleteAll();
            orderRepo.deleteAll();
            fillClient();
            fillCaffee();
            fillOrders(clientRepo.findAll(), foodRepo.findAll());
        };
    }

    private void fillOrders(List<Client> clients, List<Food> foods) {
        int i = 0;
        for (Client client : clients) {
            Order order = Order.builder()
                    .client(client)
                    .food(foods.get(i))
                    .localDate(randomDate())
                    .build();
            i++;
            orderRepo.save(order);
        }
    }

    private void fillClient() {
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            Client client = Client.builder()
                    .name(GenerateData.randomPersonName())
                    .email(GenerateData.randomEmail())
                    .password(SecurityConfig.encoder().encode(String.valueOf(random.nextInt(6) + 4)))
                    .build();
            clientRepo.save(client);
        }
    }

    private void fillCaffee() {
        for (int i = 0; i < 6; i++) {
            GenerateData.PlaceName placeName = GenerateData.randomPlace();
            Caffee caffee = Caffee.builder()
                    .name(placeName.getName())
                    .description(placeName.getDescription())
                    .build();
            fillFood(caffee);
            caffeeRepo.save(caffee);
        }
    }

    private void fillFood(Caffee caffee) {
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            GenerateData.DishName dishName = GenerateData.randomDish();
            Food food = Food.builder()
                    .name(dishName.getName())
                    .caffee(caffee)
                    .price(random.nextInt(20) + 1)
                    .type(dishName.getType())
                    .build();
            foodRepo.save(food);
        }
    }

    private LocalDate randomDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2021, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
