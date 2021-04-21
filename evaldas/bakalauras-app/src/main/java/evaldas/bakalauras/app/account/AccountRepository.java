package evaldas.bakalauras.app.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    public AccountEntity findAccountEntityByUsername(String username);
}
