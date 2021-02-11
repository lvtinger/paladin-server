package org.lvtinger.paladin.web.controller;

import org.lvtinger.paladin.profile.api.ProfileService;
import org.lvtinger.paladin.profile.api.entity.Profile;
import org.lvtinger.paladin.value.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {
    @Resource
    private ProfileService profileService;

    @RequestMapping(value = "/load.page", method = RequestMethod.GET)
    public Result<Profile> load(Long id) {
        Profile profile = profileService.load(id);
        return Result.success(profile);
    }

    @RequestMapping(value = "/save.page", method = RequestMethod.POST)
    public Result<Boolean> save(Long id, String realName, String avatar, Integer gender, Date birthday) {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setRealName(realName);
        profile.setAvatar(avatar);
        profile.setBirthday(birthday);
        profile.setGender(gender);
        profileService.save(profile);
        return Result.success();
    }
}
