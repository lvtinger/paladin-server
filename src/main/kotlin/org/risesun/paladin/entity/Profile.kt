package org.risesun.paladin.entity

class Profile : Entity<Long>() {
    var realName: String? = null
    var avatar: String? = null
    var gender: String? = null
    var birthday: String? = null
    var summary: String? = null
}