package org.risesun.paladin.utils

import java.util.*

class RandomUtils {
    companion object {
        fun uuid(): String {
            return UUID.randomUUID().toString()
        }
    }
}