package org.lvtinger.paladin.web.config;

import org.lvtinger.paladin.web.interceptor.PaladinAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PaladinConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PaladinAuthInterceptor())
                .addPathPatterns("/**");
    }
}