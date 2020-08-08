package org.risesun.paladin.core

import org.risesun.paladin.core.interceptor.PaladinInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@Component
open class PaladinWebConfig :WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(PaladinInterceptor())
            .addPathPatterns("/**")
            .order(1)
        super.addInterceptors(registry)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
        super.addCorsMappings(registry)
    }
}