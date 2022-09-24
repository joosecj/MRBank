package com.mr.bank.services;

import com.mr.bank.dto.AccountDTO;
import com.mr.bank.dto.ClientDTO;
import com.mr.bank.dto.MovementAccountDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.entities.Account;
import com.mr.bank.entities.Client;
import com.mr.bank.entities.Movement;
import com.mr.bank.enums.MovementType;
import com.mr.bank.repositories.AccountRepository;
import com.mr.bank.repositories.MovementRepository;
import com.mr.bank.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public MovementDTO findByIdMin(Long id) {
        Optional<Movement> result = movementRepository.findById(id);
        return new MovementDTO(result.get());
    }

    @Transactional(readOnly = true)
    public MovementAccountDTO findByIdWithMovement(Long id) {
        Optional<Movement> result = movementRepository.findById(id);
        return new MovementAccountDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<MovementAccountDTO> findByIdWithMovements() {
        List<Movement> result = movementRepository.findByIdWithAccounts();
        return result.stream().map(MovementAccountDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public MovementAccountDTO insertNewMovements(MovementAccountDTO movementAccountDTO){
        Movement movementEntity = new Movement();
        copyDtoToEntity(movementAccountDTO, movementEntity);
        Account result = accountRepository.findById(movementAccountDTO.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        movementEntity.setAccount(result);
        movementEntity = movementRepository.save(movementEntity);
        return new MovementAccountDTO(movementEntity);
    }

    private void copyDtoToEntity(MovementAccountDTO movementAccountDTO, Movement movementEntity) {
        LocalDateTime today = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        movementEntity.setDate(today);
        movementEntity.setValueMovement(movementAccountDTO.getValueMovement());
        movementEntity.setDescription(movementAccountDTO.getDescription());
        movementEntity.setMovementType(movementAccountDTO.getMovementType());
    }
}
