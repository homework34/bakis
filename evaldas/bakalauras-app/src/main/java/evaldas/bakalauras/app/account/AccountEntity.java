package evaldas.bakalauras.app.account;

import evaldas.bakalauras.app.authentication.AuthenticatedUser;
import evaldas.bakalauras.app.authentication.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    @Column(length = 31)
    private String firstName;

    @Column(length = 31)
    private String lastName;

    private String email;

    @Column(length = 9)
    private Long companyCode;

    private String companyName;

    private String phone;

    private String password;

    private String username;

    private RoleType roleType;

    public AccountEntity(AuthenticatedUser a, String password) {
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.email = a.getEmail();
        this.companyCode = a.getCompanyCode();
        this.companyName = a.getCompanyName();
        this.phone = a.getPhone();
        this.password = password;
        this.username = a.getUsername();
        this.roleType = a.getRoleType();
    }
}
