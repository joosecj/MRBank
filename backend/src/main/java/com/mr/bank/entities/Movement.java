package com.mr.bank.entities;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tab_movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;
    private Double valueMovement;
    private String description;
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Movement() {
    }

    public Movement(Long id, Instant date, Double valueMovement, String description, MovementType movementType) {
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
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

}
