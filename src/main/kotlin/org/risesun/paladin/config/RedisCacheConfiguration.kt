package org.risesun.paladin.config

import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers
import org.springframework.boot.autoconfigure.cache.CacheProperties
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.util.*


@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CacheProperties::class)
@EnableCaching
open class RedisCacheConfiguration {
    @Bean
    open fun cacheManager(
        cacheProperties: CacheProperties,
        redisCacheConfiguration: ObjectProvider<RedisCacheConfiguration>,
        redisCacheManagerBuilderCustomizers: ObjectProvider<RedisCacheManagerBuilderCustomizer>,
        redisConnectionFactory: RedisConnectionFactory?
    ): RedisCacheManager? {
        val builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(
            determineConfiguration(cacheProperties, redisCacheConfiguration)
        )
        val cacheNames = cacheProperties.cacheNames
        if (!cacheNames.isEmpty()) {
            builder.initialCacheNames(LinkedHashSet(cacheNames))
        }
        redisCacheManagerBuilderCustomizers.orderedStream()
            .forEach { customizer: RedisCacheManagerBuilderCustomizer ->
                customizer.customize(builder)
            }
        return CacheManagerCustomizers(null).customize(builder.build())
    }

    private fun determineConfiguration(
        cacheProperties: CacheProperties,
        redisCacheConfiguration: ObjectProvider<RedisCacheConfiguration>
    ): RedisCacheConfiguration? {
        return redisCacheConfiguration.getIfAvailable { createConfiguration(cacheProperties) }
    }

    private fun createConfiguration(
        cacheProperties: CacheProperties
    ): RedisCacheConfiguration {
        val redisProperties = cacheProperties.redis
        var config =
            RedisCacheConfiguration
                .defaultCacheConfig()
        config = config.serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer())
        )
        if (redisProperties.timeToLive != null) {
            config = config.entryTtl(redisProperties.timeToLive)
        }
        if (redisProperties.keyPrefix != null) {
            config = config.prefixCacheNameWith(redisProperties.keyPrefix)
        }
        if (!redisProperties.isCacheNullValues) {
            config = config.disableCachingNullValues()
        }
        if (!redisProperties.isUseKeyPrefix) {
            config = config.disableKeyPrefix()
        }
        return config
    }
}