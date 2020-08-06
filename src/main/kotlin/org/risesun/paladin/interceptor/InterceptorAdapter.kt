package org.risesun.paladin.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class InterceptorAdapter : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(LoginInterceptor())
                .addPathPatterns("/**")
                .order(1)
    }
}