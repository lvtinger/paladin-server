package org.lvtinger.paladin.account.api;

import org.lvtinger.paladin.value.Result;

public interface AccountService {
    Result<String> register(String username, String password);
    Result<String> login(String username, String password);
    Result<Boolean> changePassword(Long accountId, String password, String replacer);
}
