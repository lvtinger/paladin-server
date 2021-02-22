package org.lvtinger.paladin.account.api;

import org.lvtinger.paladin.account.api.entity.Identity;
import org.lvtinger.paladin.value.Result;

public interface IdentityService {
    Integer buildVerifyCode(String mobile);
    Result<Identity> checkVerifyCode(String mobile, Integer code);
    Identity get(String mobile);
}
