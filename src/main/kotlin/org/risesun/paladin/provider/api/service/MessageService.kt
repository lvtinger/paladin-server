package org.risesun.paladin.provider.api.service

import org.risesun.paladin.provider.api.entity.Message

interface MessageService {
    fun save(message: Message)

    fun cancel(member: Long, messageId: String)

    fun read(member: Long, messageId: String)

    fun delete(member: Long, ids: MutableList<String>)

    fun load(member: Long): MutableList<Message>
}