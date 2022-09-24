package com.mr.bank.dto;

import com.mr.bank.entities.Movement;
import com.mr.bank.enums.MovementType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.Instant;
import java.time.LocalDateTime;

public class MovementDTO {
    private Long id;
    private LocalDateTime date;
    private Double valueMovement;
    private String description;
    private MovementType movementType;

    public MovementDTO(Long id, LocalDateTime date, Double valueMovement, String description, MovementType movementType) {
        this.id = id;
        this.date = date;
        this.valueMovement = valueMovement;
        this.description = description;
        this.movementType = movementType;
    }

    public MovementDTO(Movement movementEntity) {
        id = movementEntity.getId();
        date = movementEntity.getDate();
        valueMovement = movementEntity.getValueMovement();
        description = movementEntity.getDescription();
        movementType = movementEntity.getMovementType();
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
}
