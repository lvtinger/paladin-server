package org.risesun.paladin.entity

import javax.persistence.Entity

@Entity
class Relation : AbstractEntity<String>() {
    var friend: Long? = null
    var relation: Int? = null
    var member: Long? = null
    var desc: String? = null
}