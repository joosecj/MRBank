package com.mr.bank.entities;


import com.mr.bank.enums.MovementType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private LocalDateTime date;
    private Double valueMovement;
    private String description;
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Movement() {
    }

    public Movement(Long id, LocalDateTime date, Double valueMovement, String description, MovementType movementType) {
        this.id = id;
        this.date = date;
        this.valueMovement = valueMovement;
        this.description = description;
        this.movementType = movementType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getValueMovement() {
        return valueMovement;
    }

    public void setValueMovement(Double valueMovement) {
        this.valueMovement = valueMovement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
