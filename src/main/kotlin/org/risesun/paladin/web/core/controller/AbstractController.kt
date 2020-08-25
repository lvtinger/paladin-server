package org.risesun.paladin.web.core.controller

import org.risesun.paladin.provider.impl.AccountServiceImpl
import org.risesun.paladin.web.core.PaladinHttpRequestContext
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class AbstractController {

    @Autowired
    protected lateinit var accountService: AccountServiceImpl

    protected fun request(): HttpServletRequest {
        return PaladinHttpRequestContext.default().request
    }

    protected fun response(): HttpServletResponse {
        return PaladinHttpRequestContext.default().response
    }

    protected fun cookie(name: String): String? {
        return request().cookies.firstOrNull { it.name == name }?.value
    }
}