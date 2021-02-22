package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Long> {
    List<Identity> findIdentityByMobile(String mobile);
}
