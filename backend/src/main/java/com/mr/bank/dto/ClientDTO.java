package com.mr.bank.dto;


import com.mr.bank.entities.Client;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String phone;


    public ClientDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public ClientDTO(Client clientEntity) {
        id = clientEntity.getId();
        name = clientEntity.getName();
        email = clientEntity.getEmail();
        cpf = clientEntity.getCpf();
        birthDate = clientEntity.getBirthDate();
        phone = clientEntity.getPhone();
    }

    public Long getId() {
        return id;
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

}
