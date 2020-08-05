package org.risesun.paladin.value

import org.risesun.paladin.constant.MessageConstantValue

class Message<T> {

    companion object {
        fun <T> success(content: T): Message<T> {
            return build(content, MessageConstantValue.RESULT_SUCCESS, MessageConstantValue.CODE_SERVER_RIGHT, null)
        }

        fun <T> failure(message: String, code: Int = MessageConstantValue.CODE_COMMON_ERROR): Message<T> {
            return build(null, MessageConstantValue.RESULT_SUCCESS, code, message)
        }

        fun <T> error(message: String, code: Int): Message<T> {
            return build(null, MessageConstantValue.RESULT_FAILURE, code, message)
        }

        private fun <T> build(content: T?, success: Boolean?, code: Int?, message: String?): Message<T> {
            val result = Message<T>()

            result.code = code
            result.content = content
            result.success = success
            result.message = message

            return result
        }
    }

    var success: Boolean? = null
    var code: Int? = null
    var message: String? = null
    var content: T? = null
}