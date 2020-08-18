package org.risesun.paladin.provider.impl.service

import org.risesun.paladin.provider.api.service.AccountService
import org.risesun.paladin.provider.impl.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : AccountService {
    @Autowired
    private lateinit var accountRepository: AccountRepository
}