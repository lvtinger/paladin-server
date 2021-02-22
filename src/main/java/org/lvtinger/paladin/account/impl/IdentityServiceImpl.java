package org.lvtinger.paladin.account.impl;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.lvtinger.paladin.account.api.IdentityService;
import org.lvtinger.paladin.account.api.entity.Identity;
import org.lvtinger.paladin.account.api.entity.VerifyCode;
import org.lvtinger.paladin.account.repo.IdentityRepository;
import org.lvtinger.paladin.account.repo.VerifyCodeRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IdentityServiceImpl implements IdentityService {

    private final IdentityRepository identityRepository;
    private final VerifyCodeRepository verifyCodeRepository;

    public IdentityServiceImpl(IdentityRepository identityRepository, VerifyCodeRepository verifyCodeRepository) {
        this.identityRepository = identityRepository;
        this.verifyCodeRepository = verifyCodeRepository;
    }

    @Override
    public Integer buildVerifyCode(String mobile) {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setMobile(mobile);
        verifyCode.setCode(RandomUtils.nextInt(100000, 999999));
        verifyCode.setUpdateTime(DateUtils.addMinutes(new Date(), 5));
        verifyCodeRepository.save(verifyCode);
        return verifyCode.getCode();
    }

    @Override
    public Result<Identity> checkVerifyCode(String mobile, Integer code) {
        VerifyCode verifyCode = verifyCodeRepository.findById(mobile).orElse(null);
        if (verifyCode == null || !verifyCode.validate(code)) {
            return Result.warning();
        }
        List<Identity> identities = identityRepository.findIdentityByMobile(mobile);
        Identity identity = identities.stream().findFirst().orElse(null);
        if (identity == null) {
            identity = new Identity();
            identity.setMobile(mobile);
            identityRepository.save(identity);
        }
        return Result.success(identity);
    }

    @Override
    public Identity get(String mobile) {
        return identityRepository.findIdentityByMobile(mobile).stream().findFirst().orElse(null);
    }
}
