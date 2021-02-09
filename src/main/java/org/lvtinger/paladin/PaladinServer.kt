package org.lvtinger.paladin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
open class PaladinServer {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            SpringApplication.run(PaladinServer::class.java, *args)
        }
    }
}