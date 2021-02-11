package org.lvtinger.paladin.relation.api;

import org.lvtinger.paladin.value.Result;

public interface RelationService {
    Result<Boolean> make(Long ownerId, Long targetId, Integer type);
}