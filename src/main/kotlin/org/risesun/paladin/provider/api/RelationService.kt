package org.risesun.paladin.provider.api

import org.risesun.paladin.provider.entity.Relation

interface RelationService {
    fun apply(member:Long, target:Long, type:Int)
    fun pass(member:Long, target:Long, type:Int)
    fun
    fun load(member:Long):MutableList<Relation>
}