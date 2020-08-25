package org.risesun.paladin.utils

import java.util.regex.Pattern

class PatternUtils {
    companion object{
        const val mobile = "^\\d\\d{10}$"

        fun matche(regex:String, input:String?):Boolean{
            if(input == null) return false
            return Pattern.matches(regex, input)
        }
    }
}