package org.risesun.paladin.controller

import org.risesun.paladin.utils.RandomUtils
import org.risesun.paladin.value.LoginRequestValue
import org.risesun.paladin.value.Message
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["/account"])
@RestController
open class AccountController {
    @RequestMapping(value = ["/login.page"], method = [RequestMethod.POST])
    fun login(@RequestBody parameter: LoginRequestValue): Message<Any?> {
        return Message.success(parameter)
    }
}