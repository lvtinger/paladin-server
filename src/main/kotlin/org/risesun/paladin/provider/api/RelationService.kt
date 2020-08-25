package org.risesun.paladin.provider.api

import org.risesun.paladin.provider.entity.Relation

interface RelationService {
    fun link(member: Long, target: Long)
    fun black(member: Long, target: Long)
    fun mark(member: Long, target: Long, name: String)
    fun load(member: Long): MutableList<Relation>
}