package org.risesun.paladin.provider.repository

import org.risesun.paladin.provider.entity.FriendShip
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendShipRepository : JpaRepository<FriendShip, String> {
    fun findByMember(member: Long): MutableList<FriendShip>
}