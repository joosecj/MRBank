package com.mr.bank.dto;

import com.mr.bank.entities.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @Size(min = 3, max = 40, message = "Nome precisar ter mínimo 3 e máximo 40 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Email(message = "Email inválido")
    @NotBlank(message = "Campo requerido")
    private String email;
    @Size(min = 11, max = 11, message = "Nome precisar ter 11 numeros, sem ponto ou traço")
    @NotBlank(message = "Campo requerido")
    private String cpf;
    @PastOrPresent(message = "Data não pode ser futura")
    private LocalDate birthDate;
    @Size(min = 7, max = 11, message = "Nome precisar ter mínimo 7 e máximo 11 numeros")
    @NotBlank(message = "Campo requerido")
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
