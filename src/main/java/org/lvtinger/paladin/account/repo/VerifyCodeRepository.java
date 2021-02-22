package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, String> {
}
