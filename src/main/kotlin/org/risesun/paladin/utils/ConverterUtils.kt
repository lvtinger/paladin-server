package org.risesun.paladin.utils

import java.lang.reflect.Member
import java.util.*

class ConverterUtils {
    companion object {
        fun toLong(value: Any?, defaultValue: Long = 0): Long {
            if (Objects.isNull(value)) {
                return defaultValue
            }
            if (value is Number) {
                return value as Long
            }

            return if (value is String) {
                try {
                    value.toLong()
                } catch (ex: Exception) {
                    defaultValue
                }
            } else {
                defaultValue
            }
        }

        fun toInit(value: Any?, defaultValue: Int? = null): Int? {
            if (Objects.isNull(value)) {
                return defaultValue
            }
            if (value is Number) {
                return value as Int
            }

            return if (value is String) {
                try {
                    value.toInt()
                } catch (ex: Exception) {
                    defaultValue
                }
            } else {
                defaultValue
            }
        }

        fun toBool(value: Any?, defaultValue: Boolean? = null): Boolean? {
            if (Objects.isNull(value)) {
                return defaultValue
            }

            if (value is Boolean) {
                return value
            }

            if (value is Member) {
                return value != 0
            }

            if (value is String) {
                return value.toLowerCase() == "true"
            }

            return defaultValue
        }
    }
}