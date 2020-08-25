package org.risesun.paladin.provider.dao

import org.risesun.paladin.provider.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(username: String): Account?
}