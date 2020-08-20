package org.risesun.paladin.provider.impl.service

import org.risesun.paladin.provider.api.entity.Account
import org.risesun.paladin.provider.api.service.AccountService
import org.risesun.paladin.provider.impl.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : AccountService {
    @Autowired
    private lateinit var accountRepository: AccountRepository
    override fun login(username: String, password: String): Account? {
        val exists = accountRepository.findByUsername(username)
        if(exists != null){
            return null
        }

        val account = Account()
        account.username = username
        account.password = password
        account.id = 1L
        account.createTime = System.currentTimeMillis()
        account.updateTime = System.currentTimeMillis()
        return accountRepository.save(account)
    }

    override fun register(account: String, password: String): Account? {
        TODO("Not yet implemented")
    }
}