package org.risesun.paladin.provider.entity

import javax.persistence.Entity

@Entity
class Message : AbstractEntity<String>() {

    var friend: Long? = null
    var member: Long? = null
    var action: Int? = null
    var type: String? = null
    var body: String? = null
    var status: Int? = null
    var serialId: String? = null

    private fun generateId() {
        this.id = "${member}-${friend}-${serialId}"
    }

    fun getOtherId(): String {
        return "${friend}-${member}-${serialId}"
    }

    fun build(): Message {
        val timestamp = System.currentTimeMillis()
        this.createTime = timestamp
        this.updateTime = timestamp
        this.status = STATUS_NORMAL
        this.action = ACTION_SENDING
        this.disabled = false
        generateId()
        return this
    }

    fun clone(): Message {
        val message = Message()
        message.friend = member
        message.member = friend
        message.action = action
        message.type = type
        message.body = body
        message.status = status
        message.serialId = serialId
        message.createTime = createTime
        message.updateTime = updateTime
        message.disabled = disabled
        message.generateId()
        return message
    }

    companion object {

        const val ACTION_SENDING = 1
        const val ACTION_RECEIVE = 2

        const val STATUS_NORMAL = 1
        const val STATUS_READED = 2
        const val STATUS_CANCEL = 4

    }
}