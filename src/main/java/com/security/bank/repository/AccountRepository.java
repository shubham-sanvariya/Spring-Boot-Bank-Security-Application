package com.security.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    Optional<Account> findByAccountNumber(Long accountNumber);

    @Query("SELECT ac FROM Account ac WHERE ac.status = 'ACTIVE' ")
    List<Account> findAllActiveAccounts();

}
