package evaldas.bakalauras.app.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class LoginRestController {

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/api/test")
    public String test() {
        return "{test: test}";
    }
}
