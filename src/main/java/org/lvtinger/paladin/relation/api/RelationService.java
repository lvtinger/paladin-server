package org.lvtinger.paladin.relation.api;

import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.value.Result;

import java.util.List;

public interface RelationService {
    Result<Boolean> make(Long ownerId, Long targetId, Integer type);
    List<Relation> getByOwner(Long ownerId);
}