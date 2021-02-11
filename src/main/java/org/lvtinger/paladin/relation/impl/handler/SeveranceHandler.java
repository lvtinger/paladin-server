package org.lvtinger.paladin.relation.impl.handler;

import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.relation.api.enums.RelationExecuteType;
import org.lvtinger.paladin.relation.api.enums.RelationType;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Component;

@Component
public class SeveranceHandler extends AbstractHandler {
    @Override
    public Integer getType() {
        return RelationExecuteType.severance.value;
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
        if (relation != null) {
            relation.setType(RelationType.stranger.value);
            relationRepository.save(relation);
        }
    }
}
