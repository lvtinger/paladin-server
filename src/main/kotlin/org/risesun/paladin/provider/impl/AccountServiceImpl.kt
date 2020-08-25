package org.risesun.paladin.provider.impl

import org.risesun.paladin.provider.api.AccountService
import org.risesun.paladin.provider.entity.Account
import org.risesun.paladin.provider.repository.AccountRepository
import org.risesun.paladin.utils.ConverterUtils
import org.risesun.paladin.compoment.RedisUtil
import org.risesun.paladin.value.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountServiceImpl : AccountService {

    @Autowired
    private lateinit var redisUtil: RedisUtil

    @Autowired
    private lateinit var accountRepository: AccountRepository

    override fun exists(username: String): Boolean {
        return accountRepository.findByUsername(username) != null
    }

    override fun token(token: String): Long? {
        return ConverterUtils.toLong(redisUtil["PALADIN_TOKEN_${token}"])
    }

    override fun login(username: String, password: String): ResponseMessage<String?> {
        val account = accountRepository.findByUsername(username) ?: return ResponseMessage.failure("账户错误")
        if (account.password != password) {
            return ResponseMessage.failure("密码错误")
        }

        val token = UUID.randomUUID().toString()
        redisUtil["PALADIN_TOKEN_${token}"] = account.id!!

        return ResponseMessage.success(token)
    }

    override fun register(username: String, password: String): ResponseMessage<String?> {
        val exists = accountRepository.findByUsername(username)
        if (exists != null) {
            return ResponseMessage.failure("用户名已存在")
        }

        val account = Account()
        account.username = username
        account.password = password
        account.id = redisUtil.incr("PALADIN_ACCOUNT_IDENTITY", 1)
        account.createTime = System.currentTimeMillis()
        account.updateTime = System.currentTimeMillis()
        accountRepository.save(account)

        val token = UUID.randomUUID().toString()
        redisUtil["PALADIN_TOKEN_${token}"] = account.id!!

        return ResponseMessage.success(token)
    }

    override fun change(id: Long, original: String, password: String): ResponseMessage<Boolean> {
        val account = accountRepository.findById(id).orElse(null) ?: return ResponseMessage.failure("登录状态错误")
        if (account.password != original) {
            return ResponseMessage.failure("密码错误")
        }

        account.password = password
        accountRepository.save(account)

        return ResponseMessage.success(true)
    }
}