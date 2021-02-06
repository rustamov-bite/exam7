package contrwork7month.contrwork7month.controllers;

import contrwork7month.contrwork7month.dto.ClientDto;
import contrwork7month.contrwork7month.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerClient(@RequestBody ClientDto clientDto,
                                               @RequestParam("password") String password) {
        if (clientDto != null && !password.isEmpty()) {
            clientService.registerClient(clientDto, password);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
