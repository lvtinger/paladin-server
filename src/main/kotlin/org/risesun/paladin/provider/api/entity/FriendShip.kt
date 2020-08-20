package org.risesun.paladin.provider.api.entity

import javax.persistence.Entity

@Entity
class FriendShip : AbstractEntity<String>() {
    var friend: Long? = null
    var type: Int? = null
    var member: Long? = null
    var remark: String? = null
}