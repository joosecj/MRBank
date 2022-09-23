package com.mr.bank.repositories;

import com.mr.bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT obj FROM Account obj JOIN FETCH obj.client")
    List<Account> findByIdWithClients();
}
