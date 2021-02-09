package org.lvtinger.paladin.account.api;

import org.lvtinger.paladin.value.Result;

public interface SessionService {
    Result<Long> val(String token);

    Result<String> set(Long userId, String device);

    Result<Boolean> exp(String token);

    Result<Boolean> exp(Long userId);
}