package org.risesun.paladin.repository

import org.risesun.paladin.entity.Relation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationRepository : JpaRepository<Relation, String> {
}