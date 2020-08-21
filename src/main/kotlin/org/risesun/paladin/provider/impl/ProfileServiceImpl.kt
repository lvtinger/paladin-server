package org.risesun.paladin.provider.impl

import org.risesun.paladin.provider.api.ProfileService
import org.risesun.paladin.provider.entity.Profile
import org.risesun.paladin.provider.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl : ProfileService {
    @Autowired
    private lateinit var profileRepository: ProfileRepository

    override fun save(profile: Profile) {
        val exists = profileRepository.findById(profile.id).orElse(null)
        if(exists == null){
            profile.createTime = System.currentTimeMillis()
        }
        profile.updateTime = System.currentTimeMillis()
        profileRepository.save(profile)
    }

    override fun getByIds(ids: MutableCollection<Long>): MutableMap<Long, Profile> {
        val profiles = profileRepository.findAllById(ids)
        return profiles.associateBy { it.id!! }.toMutableMap()
    }
}