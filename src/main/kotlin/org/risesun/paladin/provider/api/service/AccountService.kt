package org.risesun.paladin.provider.api.service

import org.risesun.paladin.provider.api.entity.Account

interface AccountService {
    fun login(account: String, password: String): Account
    fun register(account: String, password: String): Account
}