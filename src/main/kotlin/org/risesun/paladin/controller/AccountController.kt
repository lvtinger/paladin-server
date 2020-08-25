package org.risesun.paladin.controller

import org.risesun.paladin.core.controller.AbstractController
import org.risesun.paladin.provider.api.AccountService
import org.risesun.paladin.value.AccountRequestValue
import org.risesun.paladin.value.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["/account"])
@RestController
open class AccountController : AbstractController() {

    @Autowired
    private lateinit var accountService: AccountService

    @RequestMapping(value = ["/login.page"], method = [RequestMethod.POST])
    fun login(@RequestBody parameter: AccountRequestValue): ResponseMessage<Any?> {
        val message = parameter.validate()
        if (message.success != true) {
            return message as ResponseMessage<Any?>
        }

        val login = accountService.login(parameter.username!!, parameter.password!!)

        return login as ResponseMessage<Any?>
    }

    @RequestMapping(value = ["/register.page"], method = [RequestMethod.POST])
    fun register(@RequestBody parameter: AccountRequestValue): ResponseMessage<Any?> {
        val message = parameter.validate()
        if (message.success != true) {
            return message as ResponseMessage<Any?>
        }

        val register = accountService.register(parameter.username!!, parameter.password!!)
        return register as ResponseMessage<Any?>
    }
}