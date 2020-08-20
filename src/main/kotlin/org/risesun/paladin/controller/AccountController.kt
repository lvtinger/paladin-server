package org.risesun.paladin.controller

import org.risesun.paladin.constant.MessageConstantValue
import org.risesun.paladin.utils.RandomUtils
import org.risesun.paladin.value.LoginRequestValue
import org.risesun.paladin.value.ResponseMessage
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["/account"])
@RestController
open class AccountController {
    @RequestMapping(value = ["/login.page"], method = [RequestMethod.POST])
    fun login(@RequestBody parameter: LoginRequestValue): ResponseMessage<Any?> {
        return when {
            parameter.account == "risesun"
                    && parameter.password == "123456" -> {
                ResponseMessage.success(RandomUtils.uuid())
            }
            else -> {
                ResponseMessage.error("账号或者密码错误", MessageConstantValue.CODE_COMMON_ERROR)
            }
        }
    }
}