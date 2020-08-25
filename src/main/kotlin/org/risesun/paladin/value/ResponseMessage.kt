package org.risesun.paladin.value

import org.risesun.paladin.constant.MessageConstantValue
import java.io.Serializable

class ResponseMessage<T> : Serializable {
    companion object {
        private const val serialVersionUID = -6482341476084586139L

        fun <T> success(content: T): ResponseMessage<T> {
            return build(content, MessageConstantValue.RESULT_SUCCESS, MessageConstantValue.CODE_SERVER_RIGHT, null)
        }

        fun <T> failure(message: String, code: Int = MessageConstantValue.CODE_COMMON_ERROR): ResponseMessage<T> {
            return build(null, MessageConstantValue.RESULT_SUCCESS, code, message)
        }

        fun <T> error(message: String, code: Int): ResponseMessage<T> {
            return build(null, MessageConstantValue.RESULT_FAILURE, code, message)
        }

        private fun <T> build(content: T?, success: Boolean?, code: Int?, message: String?): ResponseMessage<T> {
            val result = ResponseMessage<T>()

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

    fun ok(): Boolean {
        return success == true
    }
}