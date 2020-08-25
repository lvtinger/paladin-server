package org.risesun.paladin.core.controller

import org.risesun.paladin.core.PaladinHttpRequestContext
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