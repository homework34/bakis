package evaldas.bakalauras.app.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticatedUser {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    private Long companyCode;
    private String companyName;
    private RoleType roleType;


}
