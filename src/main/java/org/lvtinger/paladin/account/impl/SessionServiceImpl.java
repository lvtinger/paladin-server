package org.lvtinger.paladin.account.impl;

import org.lvtinger.paladin.account.api.SessionService;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public Result<Long> val(String token) {
        return null;
    }

    @Override
    public Result<String> set(Long userId) {
        return null;
    }

    @Override
    public Result<Boolean> del(String token) {
        return null;
    }

    @Override
    public Result<Boolean> del(Long userId) {
        return null;
    }

}
