package org.lvtinger.paladin.profile.impl;

import org.lvtinger.paladin.profile.api.ProfileService;
import org.lvtinger.paladin.profile.api.entity.Profile;
import org.lvtinger.paladin.profile.repo.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public Profile load(Long id) {
        return profileRepository.getOne(id);
    }
}
