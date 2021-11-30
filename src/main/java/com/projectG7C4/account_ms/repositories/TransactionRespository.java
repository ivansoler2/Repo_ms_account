package com.projectG7C4.account_ms.repositories;

import java.util.List;

import com.projectG7C4.account_ms.models.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRespository extends MongoRepository <Transaction, String>{
    List<Transaction> findByUsernameDestiny(String usernameDestiny);
}
