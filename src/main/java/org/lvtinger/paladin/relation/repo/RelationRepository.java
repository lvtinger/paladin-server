package org.lvtinger.paladin.relation.repo;

import org.lvtinger.paladin.relation.api.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    Relation findByOwnerIdAndTargetId(Long ownerId, Long targetId);

    List<Relation> findByOwnerId(Long ownerId);
}
