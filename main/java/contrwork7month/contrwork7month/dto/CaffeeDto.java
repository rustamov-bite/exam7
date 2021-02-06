package contrwork7month.contrwork7month.dto;

import contrwork7month.contrwork7month.models.Caffee;
import lombok.*;
import org.springframework.data.domain.Page;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CaffeeDto {
    public static CaffeeDto from(Caffee caffee) {
        return CaffeeDto.builder()
                .id(caffee.getId())
                .name(caffee.getName())
                .build();
    }

    public static Page<CaffeeDto> fromList(Page<Caffee> caffees) {
        return caffees.map(CaffeeDto::from);
    }

    private String id;
    private String name;
}
