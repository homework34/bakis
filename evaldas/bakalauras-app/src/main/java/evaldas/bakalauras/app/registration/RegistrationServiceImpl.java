package evaldas.bakalauras.app.registration;

import evaldas.bakalauras.app.authentication.AuthenticatedUser;
import evaldas.bakalauras.app.authentication.BakalaurasUserDetailsService;
import evaldas.bakalauras.app.authentication.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BakalaurasUserDetailsService bakalaurasUserDetailsService;

    public void register(RegisterRequestDTO registerRequestDTO) {
        bakalaurasUserDetailsService.register(new AuthenticatedUser(
                registerRequestDTO.getUsername(),
                registerRequestDTO.getPassword(),
                registerRequestDTO.getEmail(),
                registerRequestDTO.getFirstName(),
                registerRequestDTO.getLastName(),
                null, null, null, null, RoleType.USER));
    }
}
