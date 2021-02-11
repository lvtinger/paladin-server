package org.lvtinger.paladin.web.controller;

import org.lvtinger.paladin.relation.api.RelationService;
import org.lvtinger.paladin.relation.api.entity.Relation;
import org.lvtinger.paladin.value.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/relation")
public class RelationController {
    @Resource
    private RelationService relationService;

    @RequestMapping(value = "/execute.page", method = RequestMethod.POST)
    public Result<Boolean> execute(Long owner, Long target, Integer type) {
        return relationService.make(owner, target, type);
    }

    @RequestMapping(value = "/load.page", method = RequestMethod.GET)
    public Result<ArrayList<Relation>> load(Long owner) {
        ArrayList<Relation> relations = new ArrayList<>(relationService.getByOwner(owner));
        return Result.success(relations);
    }
}
