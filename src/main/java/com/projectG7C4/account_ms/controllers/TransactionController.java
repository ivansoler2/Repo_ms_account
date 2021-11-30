package com.projectG7C4.account_ms.controllers;

import java.util.Date;
import java.util.List;

import com.projectG7C4.account_ms.exceptions.AccountNotFoundException;

import com.projectG7C4.account_ms.models.Account;
import com.projectG7C4.account_ms.models.Transaction;
import com.projectG7C4.account_ms.repositories.AccountRepository;
import com.projectG7C4.account_ms.repositories.TransactionRespository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    
    private TransactionRespository transactionRespository;
    private AccountRepository accountRepository;

    public TransactionController(AccountRepository accountRepository, TransactionRespository transactionRespository){
        this.accountRepository = accountRepository;
        this.transactionRespository = transactionRespository;
    }

    @PostMapping("/transactions/")
    Transaction newTransaction(@RequestBody Transaction transaction){
        Account accountDestiny = accountRepository.findById(transaction.getUsernameDestiny()).orElse(null);
        
        if(accountDestiny==null){
            throw new AccountNotFoundException("No se encontro una cuenta con el username: " + transaction.getUsernameDestiny());
        }

        accountDestiny.setBalance(accountDestiny.getBalance()+transaction.getValue());
        accountDestiny.setLastChange(new Date());
        accountRepository.save(accountDestiny);

        transaction.setDate(new Date());
        return transactionRespository.save(transaction);
    }

    @GetMapping("/transactions/{username}")
    List<Transaction> userTransaction(@PathVariable String username){
        Account userAccount = accountRepository.findById(username).orElse(null);
        if (userAccount == null)
            throw new AccountNotFoundException(username);

        List<Transaction> destinyTransactions = transactionRespository.findByUsernameDestiny(username);
        
        return destinyTransactions;
    }
    
}
