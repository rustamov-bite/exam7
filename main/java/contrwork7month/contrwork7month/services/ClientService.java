package contrwork7month.contrwork7month.services;

import contrwork7month.contrwork7month.confg.SecurityConfig;
import contrwork7month.contrwork7month.dto.ClientDto;
import contrwork7month.contrwork7month.models.Client;
import contrwork7month.contrwork7month.repo.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {
    private final ClientRepo clientRepo;

    public void registerClient(ClientDto clientDto, String password) {
        Client client = Client.builder()
                .name(clientDto.getName())
                .email(clientDto.getEmail())
                .password(SecurityConfig.encoder().encode(password))
                .build();
        clientRepo.save(client);
    }

    @Override
    public Client loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepo.findByEmail(username);
        if (client.isEmpty()) {
            throw new UsernameNotFoundException("Not found");
        }
        return client.get();
    }
}
