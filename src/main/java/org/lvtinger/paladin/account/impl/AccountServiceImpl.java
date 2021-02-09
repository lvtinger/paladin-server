package org.lvtinger.paladin.account.impl;

import org.lvtinger.paladin.account.api.AccountService;
import org.lvtinger.paladin.account.api.SessionService;
import org.lvtinger.paladin.account.api.entity.Account;
import org.lvtinger.paladin.account.repo.AccountRepository;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final SessionService sessionService;

    public AccountServiceImpl(AccountRepository accountRepository, SessionService sessionService) {
        this.accountRepository = accountRepository;
        this.sessionService = sessionService;
    }


    @Override
    public Result<String> register(String username, String password, String device) {

        if (accountRepository.existsAccountByUsernameAndDisable(username, false)) {
            return Result.<String>warning().touchMessage("账户以及存在");
        }

        Account account = Account.build(username, password);
        accountRepository.save(account);

        return sessionService.set(account.getId(), device);
    }

    @Override
    public Result<String> login(String username, String password, String device) {
        Account account = accountRepository.getAccountByUsernameAndPassword(username, password);
        if (account == null) {
            return Result.<String>warning().touchMessage("用户名或者密码错误");
        }
        if (account.getDisable()) {
            return Result.<String>warning().touchMessage("账户已被禁用");
        }
        return sessionService.set(account.getId(), device);
    }

    @Override
    public Result<Boolean> changePassword(Long accountId, String password, String replacer) {
        return null;
    }
}
