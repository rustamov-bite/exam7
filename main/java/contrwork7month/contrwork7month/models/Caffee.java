package contrwork7month.contrwork7month.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "caffees")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Caffee {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String description;


}
