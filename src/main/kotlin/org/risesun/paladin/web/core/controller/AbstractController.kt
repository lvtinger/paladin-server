package org.risesun.paladin.web.core.controller

import org.risesun.paladin.web.core.PaladinHttpRequestContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class AbstractController {

    protected fun request(): HttpServletRequest {
        return PaladinHttpRequestContext.default().request
    }

    protected fun response(): HttpServletResponse {
        return PaladinHttpRequestContext.default().response
    }
}