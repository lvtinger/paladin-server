package org.risesun.paladin.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.net.UnknownHostException


@ConditionalOnClass(RedisOperations::class)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RedisProperties::class)
open class RedisConfig {
    @Bean
    @Primary
    open fun redisTemplate(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Any>? {
        //设置序列化
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer<Any>(Any::class.java)
        val om = ObjectMapper()
        // 所有属性都可见,包括私有的，但是没有get set方法的字段也会实例化
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        //序列化时允许非常量字段均输出类型,序列化时输出类型，为了反序列化时使用
        om.activateDefaultTyping(
            LaissezFaireSubTypeValidator.instance,
            ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY
        )
        // ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
        jackson2JsonRedisSerializer.setObjectMapper(om)

        // 配置redisTemplate
        val redisTemplate = RedisTemplate<String, Any>()
        val stringSerializer: RedisSerializer<*> = StringRedisSerializer()
        // key序列化
        redisTemplate.keySerializer = stringSerializer
        // value序列化
        redisTemplate.valueSerializer = jackson2JsonRedisSerializer
        // Hash key序列化
        redisTemplate.hashKeySerializer = stringSerializer
        // Hash value序列化
        redisTemplate.hashValueSerializer = jackson2JsonRedisSerializer
        redisTemplate.connectionFactory = redisConnectionFactory
        redisTemplate.afterPropertiesSet()
        return redisTemplate
    }

    @Bean
    @ConditionalOnMissingBean
    @Throws(UnknownHostException::class)
    open fun stringRedisTemplate(redisConnectionFactory: RedisConnectionFactory?): StringRedisTemplate? {
        val template = StringRedisTemplate()
        template.connectionFactory = redisConnectionFactory
        return template
    }
}