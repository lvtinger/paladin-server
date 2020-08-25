package org.risesun.paladin.core.interceptor

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
open class PaladinInterceptor : HandlerInterceptor {

    private val logger = LoggerFactory.getLogger(PaladinInterceptor::class.java)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        logger.info(request.requestURI)
        return true
    }
}