package org.lvtinger.paladin.profile.api;

import org.lvtinger.paladin.profile.api.entity.Profile;

public interface ProfileService {
    void save(Profile profile);
    Profile load(Long id);
}