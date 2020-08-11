package org.risesun.paladin.entity

import javax.persistence.Entity

@Entity
class Relation : AbstractEntity<String>() {
    var friendId: Long? = null
    var relation: Int? = null
    var memberId: Long? = null
    var describe: String? = null
}