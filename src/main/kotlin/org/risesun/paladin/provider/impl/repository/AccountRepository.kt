package org.risesun.paladin.provider.impl.repository

import org.risesun.paladin.provider.api.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(username: String): Account?
}