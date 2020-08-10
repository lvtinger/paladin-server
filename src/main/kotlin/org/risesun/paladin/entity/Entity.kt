package org.risesun.paladin.entity

import java.io.Serializable

abstract class Entity<Id> : Serializable {
    var id: Id? = null
    var disabled: Boolean? = null
    var createTime: Long? = null
    var updateTime: Long? = null
}