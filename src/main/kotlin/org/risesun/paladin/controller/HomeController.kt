package org.risesun.paladin.controller

import org.risesun.paladin.utils.ConverterUtils
import org.risesun.paladin.utils.RedisUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
open class HomeController {
    @Autowired
    private lateinit var redisUtil: RedisUtil

    @RequestMapping("/welcome", method = [RequestMethod.GET])
    open fun welcome(): String {
        return "hello world"
    }

    @RequestMapping("/redis/set", method = [RequestMethod.GET])
    open fun set():Long{
        val millis = System.currentTimeMillis()
        redisUtil.set("current", millis)
        redisUtil.expire("current", 60 * 60)
        return millis
    }

    @RequestMapping("/redis/get", method = [RequestMethod.GET])
    open fun get(): Long {
        val cachedValue = redisUtil.get("current")
        return ConverterUtils.toLong(cachedValue, 0L)
    }
}