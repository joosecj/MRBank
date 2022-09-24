package com.mr.bank.dto;

import com.mr.bank.entities.Account;
import com.mr.bank.entities.Movement;
import com.mr.bank.enums.MovementType;

import java.time.Instant;
import java.time.LocalDateTime;

public class MovementAccountDTO {
    private Long id;
    private LocalDateTime date;
    private Double valueMovement;
    private String description;
    private MovementType movementType;
    private AccountDTO account;

    public MovementAccountDTO() {
    }

    public MovementAccountDTO(Long id, LocalDateTime date, Double valueMovement, String description, MovementType movementType, AccountDTO account) {
        this.id = id;
        this.date = date;
        this.valueMovement = valueMovement;
        this.description = description;
        this.movementType = movementType;
        this.account = account;
    }

    public MovementAccountDTO(Movement movementEntity) {
        id = movementEntity.getId();
        date = movementEntity.getDate();
        valueMovement = movementEntity.getValueMovement();
        description = movementEntity.getDescription();
        movementType = movementEntity.getMovementType();
        account = new AccountDTO(movementEntity.getAccount());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getValueMovement() {
        return valueMovement;
    }

    public String getDescription() {
        return description;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public Long getAccountId() {
        return this.account.getId();
    }

}
