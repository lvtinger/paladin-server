package org.lvtinger.paladin.web;

import org.apache.commons.lang3.StringUtils;
import org.lvtinger.paladin.account.api.AccountService;
import org.lvtinger.paladin.account.api.SessionService;
import org.lvtinger.paladin.value.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Resource
    private AccountService accountService;
    @Resource
    private SessionService sessionService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<String> register(String username, String password, String device) {
        if (StringUtils.isAnyBlank(username, password, device)) {
            return Result.<String>warning().touchMessage("参数错误");
        }
        return accountService.register(username, password, device);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> login(String username, String password, String device) {
        if (StringUtils.isAnyBlank(username, password, device)) {
            return Result.<String>warning().touchMessage("参数错误");
        }
        return accountService.login(username, password, device);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Boolean> logout(String token) {
        if (StringUtils.isEmpty(token)) {
            return Result.success(false);
        }
        if (sessionService.exp(token).getCode() == Result.SUCCESS) {
            return Result.success(true);
        } else {
            return Result.success(false);
        }
    }
}
