package org.lvtinger.paladin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.lvtinger.paladin.account.api.IdentityService;
import org.lvtinger.paladin.account.api.SessionService;
import org.lvtinger.paladin.account.api.entity.Identity;
import org.lvtinger.paladin.value.Result;
import org.lvtinger.paladin.web.value.CodeValue;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/identity")
public class IdentityController {
    @Resource
    private IdentityService identityService;
    @Resource
    private SessionService sessionService;

    @RequestMapping(value = "/generateCode", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> getVerifyCode(@RequestBody CodeValue codeValue) {
        if (StringUtils.isEmpty(codeValue.getMobile())) {
            return Result.<Boolean>warning().touchMessage("参数错误");
        }
        Integer code = identityService.buildVerifyCode(codeValue.getMobile());
        return Result.success(code > 0);
    }

    @RequestMapping(value = "/validateCode", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> checkVerifyCode(@RequestBody CodeValue codeValue) {
        Result<Identity> identityResult = identityService.checkVerifyCode(codeValue.getMobile(), codeValue.getCode());
        if (identityResult.error()) {
            return Result.warning();
        }

        return sessionService.set(identityResult.getContent().getId(), "mobile");
    }
}