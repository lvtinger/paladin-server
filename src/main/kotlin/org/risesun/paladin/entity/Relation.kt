package org.risesun.paladin.entity

class Relation : Entity<String>() {
    var friendId: Long? = null
    var relation: Int? = null
    var memberId: Long? = null
    var describe: String? = null
}