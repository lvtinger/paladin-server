package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
