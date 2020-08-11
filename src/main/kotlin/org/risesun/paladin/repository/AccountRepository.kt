package org.risesun.paladin.repository

import org.risesun.paladin.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(username: String): Account
}