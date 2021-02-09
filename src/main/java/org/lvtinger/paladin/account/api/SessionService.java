package org.lvtinger.paladin.account.api;

import org.lvtinger.paladin.value.Result;

public interface SessionService {
    Result<Long> val(String token);

    Result<String> set(Long userId);

    Result<Boolean> del(String token);

    Result<Boolean> del(Long userId);
}