package org.risesun.paladin.repository

import org.risesun.paladin.entity.Account
import org.risesun.paladin.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, Long> {
}