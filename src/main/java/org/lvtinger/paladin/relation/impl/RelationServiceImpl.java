package org.lvtinger.paladin.relation.impl;

import org.lvtinger.paladin.core.SpringBeanSupport;
import org.lvtinger.paladin.relation.api.RelationService;
import org.lvtinger.paladin.relation.impl.handler.RelationHandler;
import org.lvtinger.paladin.relation.repo.RelationRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelationServiceImpl extends SpringBeanSupport implements RelationService {

    private final RelationRepository relationRepository;

    private final Map<Integer, RelationHandler> relationHandlerHolder = new HashMap<>();


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
    public void afterPropertiesSet() {
        List<RelationHandler> relationHandlers = this.getBeanByType(RelationHandler.class);
        relationHandlers.forEach(handler -> relationHandlers.set(handler.getType(), handler));
    }
}
