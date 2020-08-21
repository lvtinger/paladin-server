package org.risesun.paladin.provider.impl

import org.risesun.paladin.provider.api.RelationService
import org.risesun.paladin.provider.entity.Relation
import org.risesun.paladin.provider.repository.RelationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RelationServiceImpl : RelationService {
    @Autowired
    private lateinit var relationRepository: RelationRepository

    override fun apply(member: Long, target: Long, type: Int) {

    }

    override fun load(member: Long): MutableList<Relation> {
        TODO("Not yet implemented")
    }

}