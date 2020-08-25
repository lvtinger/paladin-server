package org.risesun.paladin.provider.entity

import javax.persistence.Entity

@Entity
class Relation : AbstractEntity<String>() {
    var friend: Long? = null
    var type: Int? = null
    var member: Long? = null
    var remark: String? = null

    fun build(member: Long, friend: Long, type: Int): Relation {
        this.id = "${member}-${friend}"
        this.friend = friend
        this.member = member
        this.type = type
        this.createTime = System.currentTimeMillis()
        this.updateTime = System.currentTimeMillis()
        return this
    }

    companion object {
        const val TYPE_APPLY = 0
        const val TYPE_CHECK = 1
        const val TYPE_REFUSE = 3
        const val TYPE_BREAK  = 5
        const val TYPE_BLACK = 2
        const val TYPE_FRIEND = 4

        fun generateId(member: Long, friend: Long): String {
            return "${member}-${friend}"
        }
    }
}