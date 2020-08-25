package org.risesun.paladin.value

import org.apache.commons.lang3.StringUtils
import org.risesun.paladin.utils.PatternUtils
import java.io.Serializable

class AccountRequestValue : Serializable {
    companion object {
        private const val serialVersionUID = 5721259460711280176L
    }

    var username: String? = null
    var password: String? = null

    fun validate(): ResponseMessage<Any> {
        if (StringUtils.isEmpty(username)) {
            return ResponseMessage.failure("账户不为空")
        }

        if(!PatternUtils.matche(PatternUtils.mobile, username)){
            return ResponseMessage.failure("账户为手机号")
        }

        if (StringUtils.isEmpty(password)) {
            return ResponseMessage.failure("密码不为空")
        }

        if(password!!.length < 6){
            return ResponseMessage.failure("密码长度不足")
        }

        return ResponseMessage.success("")
    }
}