package org.risesun.paladin.provider.repository

import org.risesun.paladin.provider.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, String> {
    fun findBySerialId(serializeId: String): MutableList<Message>
    fun findByMember(member: Long): MutableList<Message>
}