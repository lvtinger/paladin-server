package org.lvtinger.paladin.relation.impl;

import org.lvtinger.paladin.support.SpringBeanSupport;
import org.lvtinger.paladin.relation.api.RelationService;
import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.relation.impl.handler.RelationHandler;
import org.lvtinger.paladin.relation.repo.RelationRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelationServiceImpl extends SpringBeanSupport implements RelationService {

    private final Map<Integer, RelationHandler> relationHandlerHolder = new HashMap<>();

    private final RelationRepository relationRepository;

    public RelationServiceImpl(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

    @Override
    public Result<Boolean> make(Long ownerId, Long targetId, Integer type) {
        RelationHandler handler = relationHandlerHolder.get(type);
        if (handler == null) {
            return Result.<Boolean>feature().touchMessage("操作类型错误");
        }
        return handler.execute(ownerId, targetId);
    }

    @Override
    public List<Relation> getByOwner(Long ownerId) {
        return relationRepository.findByOwnerId(ownerId);
    }

    @Override
    public void afterPropertiesSet() {
        List<RelationHandler> relationHandlers = this.getBeanByType(RelationHandler.class);
        relationHandlers.forEach(handler -> relationHandlerHolder.put(handler.getType(), handler));
    }
}
