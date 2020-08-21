package org.risesun.paladin.provider.api

import org.risesun.paladin.provider.entity.Profile

interface ProfileService {
    fun save(profile: Profile)
    fun getByIds(ids:MutableCollection<Long>):MutableMap<Long, Profile>
}