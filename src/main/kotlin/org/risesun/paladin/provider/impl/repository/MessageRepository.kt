package org.risesun.paladin.provider.impl.repository

import org.risesun.paladin.provider.api.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, String> {
    fun findBySerialId(serializeId: String): MutableList<Message>
    fun findByMember(member: Long): MutableList<Message>
}