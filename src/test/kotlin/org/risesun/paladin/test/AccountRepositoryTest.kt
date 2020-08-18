package org.risesun.paladin.test

import org.junit.Test
import org.junit.runner.RunWith
import org.risesun.paladin.entity.Account
import org.risesun.paladin.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun test() {
        val account = Account()
        account.id = 1L
        account.username = "risesun"
        account.password = "123456"
        account.impurity = "paladin"
        account.disabled = false
        accountRepository.save(account)

        val account1 = accountRepository.findByUsername("risesun")
        val account2 = accountRepository.findById(1L).get()
        println(account1.id)
        println(account2.username)
    }
}