package org.risesun.paladin.provider.impl

import org.risesun.paladin.provider.api.RelationService
import org.risesun.paladin.provider.entity.Relation
import org.risesun.paladin.provider.dao.RelationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RelationServiceImpl : RelationService {
    @Autowired
    private lateinit var relationRepository: RelationRepository
    override fun link(member: Long, target: Long) {
        val memberRelation = Relation().build(member, target, Relation.TYPE_FRIEND)
        relationRepository.save(memberRelation)
        val friendRelation = Relation().build(target, member, Relation.TYPE_FRIEND)
        relationRepository.save(friendRelation)
    }

    override fun black(member: Long, target: Long) {
        val friendRelation = Relation().build(target, member, Relation.TYPE_FRIEND)
        relationRepository.save(friendRelation)
    }

    override fun mark(member: Long, target: Long, name: String) {
        val id = Relation.generateId(member, target)
        val relation = relationRepository.findByIdOrNull(id) ?: return
        relation.remark = name
        relationRepository.save(relation)
    }

    override fun load(member: Long): MutableList<Relation> {
        return relationRepository.findByMember(member)
    }


}