package org.lvtinger.paladin.message.repo;

import org.lvtinger.paladin.message.api.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getMessageByOwner(Long owner);
    List<Message> getMessageByUniqueId(String uniqueId);
}