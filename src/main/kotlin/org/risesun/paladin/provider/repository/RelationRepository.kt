package org.risesun.paladin.provider.repository

import org.risesun.paladin.provider.entity.Relation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationRepository : JpaRepository<Relation, String> {
    fun findByMember(member: Long): MutableList<Relation>
}