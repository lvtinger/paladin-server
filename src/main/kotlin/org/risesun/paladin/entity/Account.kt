package org.risesun.paladin.entity

class Account : Entity<Long>() {
    var username: String? = null
    var password: String? = null
    var impurity: String? = null
}