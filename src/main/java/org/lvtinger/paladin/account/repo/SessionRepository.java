package org.lvtinger.paladin.account.repo;

import org.lvtinger.paladin.account.api.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session getSessionByUserIdAndDevice(Long userId, String device);
    Session getSessionByToken(String token);
    List<Session> getSessionsByUserId(Long userId);
}
