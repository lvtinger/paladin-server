package org.risesun.paladin.controller

import org.risesun.paladin.utils.RandomUtils
import org.risesun.paladin.value.Message
import org.springframework.web.bind.annotation.RestController

@RestController
open class AccountController {
    fun login(account: String, password: String): Message<String> {
        return Message.success(RandomUtils.uuid())
    }

}