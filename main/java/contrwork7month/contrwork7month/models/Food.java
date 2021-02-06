package contrwork7month.contrwork7month.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "foods")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Food {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String type;
    private Integer price;
}
