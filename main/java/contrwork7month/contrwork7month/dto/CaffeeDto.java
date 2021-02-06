package contrwork7month.contrwork7month.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CaffeeDto {
    private String id;
    private String name;
}
