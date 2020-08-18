package org.risesun.paladin.provider.impl.repository

import org.risesun.paladin.provider.api.entity.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : JpaRepository<Profile, Long> {
}