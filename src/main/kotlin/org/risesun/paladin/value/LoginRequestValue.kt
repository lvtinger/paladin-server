package org.risesun.paladin.value

import java.io.Serializable

class LoginRequestValue : Serializable {
    companion object {
        private const val serialVersionUID = 5721259460711280176L
    }

    var account: String? = null
    var password: String? = null
}