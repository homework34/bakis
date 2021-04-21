package evaldas.bakalauras.app.authentication;

import evaldas.bakalauras.app.account.AccountEntity;
import evaldas.bakalauras.app.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BakalaurasUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity account = accountRepository.findAccountEntityByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username + " user not found");
        }
        return new BakalaurasUserDetails(account);
    }

    public void register(AuthenticatedUser authenticatedUser) {
        if (accountRepository.findAccountEntityByUsername(authenticatedUser.getUsername()) != null) {
            throw new RuntimeException("User with login already exists");
        }
        accountRepository.save(new AccountEntity(authenticatedUser,
                bCryptPasswordEncoder.encode(authenticatedUser.getPassword())));
    }
}
