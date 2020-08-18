package org.risesun.paladin.entity

import java.io.Serializable
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractEntity<ID : Serializable> : Serializable {
    @Id
    var id: ID? = null
    var disabled: Boolean? = null
    var createTime: Long? = null
    var updateTime: Long? = null
}