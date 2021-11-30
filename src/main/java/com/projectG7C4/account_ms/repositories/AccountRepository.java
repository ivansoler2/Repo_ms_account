package com.projectG7C4.account_ms.repositories;

import com.projectG7C4.account_ms.models.Account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository < Account, String >{
    
}
