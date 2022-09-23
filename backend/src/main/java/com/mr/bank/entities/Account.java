package com.mr.bank.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long agency;
    private Long numberCc;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Movement> movementList = new ArrayList<>();


    public Account() {
    }

    public Account(Long agency, Long numberCc, Double balance) {
        this.agency = agency;
        this.numberCc = numberCc;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgency() {
        return agency;
    }

    public void setAgency(Long agency) {
        this.agency = agency;
    }

    public Long getNumberCc() {
        return numberCc;
    }

    public void setNumberCc(Long numberCc) {
        this.numberCc = numberCc;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Movement> getMovementList() {
        return movementList;
    }

}
