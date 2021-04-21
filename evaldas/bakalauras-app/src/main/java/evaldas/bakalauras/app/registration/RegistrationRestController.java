package evaldas.bakalauras.app.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth/register")
@RequiredArgsConstructor
public class RegistrationRestController {

    private final RegistrationService registrationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        registrationService.register(registerRequestDTO);
    }
}
