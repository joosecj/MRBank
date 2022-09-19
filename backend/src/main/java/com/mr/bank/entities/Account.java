package com.mr.bank.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer agency;
    private Instant number;
    private Double balance;
    @OneToOne
    @MapsId
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Movement> movementList = new ArrayList<>();


    public Account() {
    }

    public Account(Integer agency, Instant number, Double balance) {
        this.agency = agency;
        this.number = number;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Instant getNumber() {
        return number;
    }

    public void setNumber(Instant number) {
        this.number = number;
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
