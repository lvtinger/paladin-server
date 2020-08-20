package org.risesun.paladin.provider.entity

import javax.persistence.Entity

@Entity
class Account : AbstractEntity<Long>() {
    var username: String? = null
    var password: String? = null
    var impurity: String? = null
}