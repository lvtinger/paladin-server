package org.risesun.paladin.repository

import org.risesun.paladin.entity.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long> {
}