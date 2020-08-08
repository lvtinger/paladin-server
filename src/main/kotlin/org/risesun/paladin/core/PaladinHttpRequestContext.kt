package org.risesun.paladin.core

import org.risesun.paladin.core.filter.PaladinFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class PaladinHttpRequestContext(request: HttpServletRequest, response: HttpServletResponse) {
    companion object {
        fun default(): PaladinHttpRequestContext {
            return PaladinFilter.context.get()
        }
    }

    val request: HttpServletRequest = request
    val response: HttpServletResponse = response
}