package contrwork7month.contrwork7month.services;

import contrwork7month.contrwork7month.models.Caffee;
import contrwork7month.contrwork7month.repo.CaffeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CaffeeService {
    private final CaffeeRepo caffeeRepo;

    public Page<Caffee> getCaffees(Pageable pageable) {
        return caffeeRepo.findAll(pageable);
    }
}
