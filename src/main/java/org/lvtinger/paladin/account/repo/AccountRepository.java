package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsAccountByUsernameAndDisable(String username, Boolean disable);
    Account getAccountByUsernameAndPassword(String username, String password);
}
