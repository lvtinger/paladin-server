package org.risesun.paladin.web.core.controller

import org.risesun.paladin.utils.ConverterUtils

abstract class AbstractAuthController : AbstractController() {

    fun validateAuthorize(): Boolean {
        return currentUserId() > 0
    }

    fun currentUserId(): Long {
        val value = cookie("ACCESS_TOKEN") ?: return 0L
        return ConverterUtils.toLong(value)
    }
}