package com.security.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    
}
