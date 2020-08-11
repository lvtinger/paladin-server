package org.risesun.paladin.entity

import javax.persistence.Entity

@Entity
class Profile : AbstractEntity<Long>() {
    var realName: String? = null
    var avatar: String? = null
    var gender: String? = null
    var birthday: String? = null
    var summary: String? = null
}