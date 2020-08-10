package org.risesun.paladin.repository

import org.risesun.paladin.entity.Relation
import org.springframework.data.jpa.repository.JpaRepository

interface RelationRepository : JpaRepository<Relation, String> {
}