package org.risesun.paladin.web.core.interceptor

import lombok.extern.slf4j.Slf4j
import org.risesun.paladin.constant.MessageConstantValue
import org.risesun.paladin.utils.JsonUtils
import org.risesun.paladin.value.ResponseMessage
import org.risesun.paladin.web.core.controller.AbstractAuthController
import org.slf4j.LoggerFactory
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
open class PaladinInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (!authorize(response, handler)) {
            return false
        }

        return true
    }

    private fun authorize(response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            if (handler.bean is AbstractAuthController) {
                if (!(handler.bean as AbstractAuthController).validateAuthorize()) {
                    val message = ResponseMessage.error<Any?>("", MessageConstantValue.CODE_POWER_ERROR)
                    val writer = response.writer
                    writer.write(JsonUtils.toJson(message))
                    return false
                }
            }
        }
        return true
    }
}