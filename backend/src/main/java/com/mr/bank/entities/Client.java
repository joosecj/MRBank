package com.mr.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private LocalDate birthDate;
    @Column(unique = true)
    private String phone;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Account account;
    
    public Client() {
    }

    public Client(Long id, String name, String email, String cpf, LocalDate birthDate, String phone, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
