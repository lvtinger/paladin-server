package org.risesun.paladin.provider.api

import org.risesun.paladin.provider.entity.Account
import org.risesun.paladin.value.ResponseMessage

interface AccountService {
    fun exists(username: String): Boolean
    fun token(token:String):Long?
    fun login(username: String, password: String): ResponseMessage<String>
    fun register(username: String, password: String): ResponseMessage<Account>
}