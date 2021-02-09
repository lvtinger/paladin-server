package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Long, Session> {
}
