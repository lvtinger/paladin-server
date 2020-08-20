package org.risesun.paladin.provider.api.service

import org.risesun.paladin.provider.api.entity.Account

interface AccountService {
    fun login(username: String, password: String): Account?
    fun register(account: String, password: String): Account?
}