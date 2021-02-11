package org.lvtinger.paladin.relation.impl.handler;

import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.relation.api.enums.RelationExecuteType;
import org.lvtinger.paladin.relation.api.enums.RelationType;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Component;

@Component
public class EstablishHandler extends AbstractHandler {
    @Override
    public Integer getType() {
        return RelationExecuteType.establish.value;
    }

    @Override
    public Result<Boolean> execute(Long source, Long target) {
        if (blackList(source, target)) {
            return Result.warning();
        }
        doExecute(source, target);
        doExecute(target, source);
        return Result.success();
    }

    private void doExecute(Long source, Long target) {
        Relation relation = relationRepository.findByOwnerIdAndTargetId(source, target);
        if (relation == null) {
            relation = new Relation();
            relation.setOwnerId(source);
            relation.setTargetId(target);
        }
        relation.setStatus(1);
        relation.setType(RelationType.friend.value);
        relationRepository.save(relation);
    }
}
