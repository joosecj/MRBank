package com.mr.bank.dto;

import com.mr.bank.entities.Account;

public class AccountDTO {
    private Long id;
    private Long agency;
    private Long numberCc;
    private Double balance;

    public AccountDTO(Long id, Long agency, Long numberCc, Double balance) {
        this.id = id;
        this.agency = agency;
        this.numberCc = numberCc;
        this.balance = balance;
    }

    public AccountDTO(Account accountEntity) {
        id = accountEntity.getId();
        agency = accountEntity.getAgency();
        numberCc = accountEntity.getNumberCc();
        balance = accountEntity.getBalance();
    }

    public Long getId() {
        return id;
    }

    public Long getAgency() {
        return agency;
    }

    public Long getNumberCc() {
        return numberCc;
    }

    public Double getBalance() {
        return balance;
    }
}
