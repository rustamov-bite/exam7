package contrwork7month.contrwork7month.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "clients")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Order {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @DBRef
    private Client client;

    @DBRef
    private Food food;

    private LocalDate localDate;
}
