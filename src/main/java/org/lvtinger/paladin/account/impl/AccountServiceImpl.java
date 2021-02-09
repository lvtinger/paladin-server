package org.lvtinger.paladin.account.impl;

import org.lvtinger.paladin.account.api.AccountService;
import org.lvtinger.paladin.value.Result;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Result<String> register(String username, String password) {
        /*Integer count = accountMapper.selectCount(new QueryWrapper<Account>().lambda().eq(Account::getUsername, username));
        if (count >= 1) {
            return Result.<String>warning().touchMessage("账户已经存在");
        }

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setCreateTime(System.currentTimeMillis());
        account.setUpdateTime(System.currentTimeMillis());
        account.setStatus(1);
        accountMapper.insert(account);*/
        return null;
    }

    @Override
    public Result<String> login(String username, String password) {
        /*Account account = accountMapper.selectOne(new QueryWrapper<Account>().lambda().eq(Account::getUsername, username));
        if(account == null){
            return null;
        }
        if (StringUtils.equals(account.getPassword(), password)) {
            return "";
        }*/
        return null;
    }

    @Override
    public Result<Boolean> changePassword(Long accountId, String password, String replacer) {
        return null;
    }
}
