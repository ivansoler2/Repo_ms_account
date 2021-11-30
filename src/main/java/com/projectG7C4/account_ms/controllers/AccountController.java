package com.projectG7C4.account_ms.controllers;


import java.util.Date;

import com.projectG7C4.account_ms.exceptions.AccountNotFoundException;
import com.projectG7C4.account_ms.models.Account;
import com.projectG7C4.account_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;



@RestController
public class AccountController {


    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) 
    {
        this.accountRepository = accountRepository; 
    }

    

    @GetMapping("/accounts/{username}")
    Account getAccount(@PathVariable String username){
        return accountRepository.findById(username)
            .orElseThrow(()-> new AccountNotFoundException(username));
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        account.setLastChange(new Date());
        return accountRepository.save(account);
    }
}
