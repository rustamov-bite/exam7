package contrwork7month.contrwork7month.controllers;

import contrwork7month.contrwork7month.dto.CaffeeDto;
import contrwork7month.contrwork7month.services.CaffeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/caffees")
@AllArgsConstructor
public class CaffeeController {
    private final CaffeeService caffeeService;

    @GetMapping("/allCaffees")
    public Page<CaffeeDto> getAllCaffees(@ApiIgnore Pageable pageable) {
        return CaffeeDto.fromList(caffeeService.getCaffees(pageable));
    }
}
