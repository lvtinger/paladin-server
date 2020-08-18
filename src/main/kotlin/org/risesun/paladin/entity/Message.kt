package org.risesun.paladin.entity

import javax.persistence.Entity

@Entity
class Message : AbstractEntity<String>() {
    var friend: Long? = null
    var member: Long? = null
    var action: Int? = null
    var type: String? = null
    var body: String? = null
    var status: Int? = null
}