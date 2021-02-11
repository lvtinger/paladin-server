package org.lvtinger.paladin.relation.impl.handler;

import org.lvtinger.paladin.value.Result;

public interface RelationHandler {
    Integer getType();
    Result<Boolean> execute(Long source, Long target);
}