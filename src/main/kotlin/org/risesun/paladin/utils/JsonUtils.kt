package org.risesun.paladin.utils

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.text.SimpleDateFormat


class JsonUtils {

    private val objectMapper: ObjectMapper = ObjectMapper()

    private constructor() {
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.configOverride(JsonIgnore::class.java)
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        objectMapper.dateFormat = dateFormat

    }

    companion object {

        private const val EMPTY = "{}"

        private val current: JsonUtils = JsonUtils()

        fun toJson(bean: Any?): String? {
            if (bean == null) return null
            return current.objectMapper.writeValueAsString(bean)
        }

    }
}