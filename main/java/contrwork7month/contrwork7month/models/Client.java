package contrwork7month.contrwork7month.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "clients")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Client {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String email;
    private String password;
}
