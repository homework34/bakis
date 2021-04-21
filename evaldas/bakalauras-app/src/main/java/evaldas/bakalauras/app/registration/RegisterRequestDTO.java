package evaldas.bakalauras.app.registration;

import evaldas.bakalauras.app.authentication.RoleType;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    private String companyCode;
    private String companyName;
    private RoleType roleType;
}
