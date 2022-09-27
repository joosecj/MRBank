package com.mr.bank.repositories;

import com.mr.bank.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    @Query("SELECT obj FROM Movement obj JOIN FETCH obj.account")
    List<Movement> findByIdWithAccounts();

    @Query("SELECT obj FROM Movement obj JOIN FETCH obj.account.id")
    List<Movement> findMovementsWithAccountId(Long id);
}
