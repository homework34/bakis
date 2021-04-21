package evaldas.bakalauras.app.authentication;

import evaldas.bakalauras.app.account.AccountEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class BakalaurasUserDetails implements UserDetails {

    private String username;

    private String password;

    private List<GrantedAuthority> authorities;

    public BakalaurasUserDetails(AccountEntity user) {
        this.username = user.getUsername();
        this.password = this.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getRoleType().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
