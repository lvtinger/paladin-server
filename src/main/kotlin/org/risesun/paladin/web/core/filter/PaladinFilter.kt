package org.risesun.paladin.web.core.filter

import org.risesun.paladin.web.core.PaladinHttpRequestContext
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@WebFilter(filterName = "paladinFilter", urlPatterns = ["/**"])
@Order(1)
class PaladinFilter : OncePerRequestFilter() {
    companion object {
        val context = ThreadLocal<PaladinHttpRequestContext>()
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            context.set(PaladinHttpRequestContext(request, response))
            filterChain.doFilter(request, response)
        } finally {
            context.remove()
        }
    }
}