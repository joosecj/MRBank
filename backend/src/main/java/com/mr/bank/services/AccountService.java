package com.mr.bank.services;

import com.mr.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
}
