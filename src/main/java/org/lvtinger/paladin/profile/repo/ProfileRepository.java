package org.lvtinger.paladin.profile.repo;

import org.lvtinger.paladin.profile.api.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
