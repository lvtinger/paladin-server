package org.lvtinger.paladin.relation.impl.handler;

import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.relation.api.enums.RelationType;
import org.lvtinger.paladin.relation.repo.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHandler implements RelationHandler {
    @Autowired
    protected RelationRepository relationRepository;

    protected boolean blackList(Long source, Long target) {
        Relation relation = relationRepository.findByOwnerIdAndTargetId(source, target);
        return relation != null && relation.getType() == RelationType.blacklist.value;
    }
}
