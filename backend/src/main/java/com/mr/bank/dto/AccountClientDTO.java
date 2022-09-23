package com.mr.bank.dto;

import com.mr.bank.entities.Account;

public class AccountClientDTO {
    private Long id;
    private Long agency;
    private Long numberCc;
    private Double balance;
    private ClientDTO client;


    public AccountClientDTO(Long id, Long agency, Long numberCc, Double balance, ClientDTO client) {
        this.id = id;
        this.agency = agency;
        this.numberCc = numberCc;
        this.balance = balance;
        this.client = client;
    }

    public AccountClientDTO(Account accountEntity) {
        id = accountEntity.getId();
        agency = accountEntity.getAgency();
        numberCc = accountEntity.getNumberCc();
        balance = accountEntity.getBalance();
        client = new ClientDTO(accountEntity.getClient());
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

    public ClientDTO getClient() {
        return client;
    }
}
