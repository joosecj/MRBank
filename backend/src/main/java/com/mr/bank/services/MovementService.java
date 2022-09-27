package com.mr.bank.services;

import com.mr.bank.dto.MovementAccountDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.entities.Account;
import com.mr.bank.entities.Movement;
import com.mr.bank.enums.MovementType;
import com.mr.bank.repositories.AccountRepository;
import com.mr.bank.repositories.MovementRepository;
import com.mr.bank.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        Movement result = movementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new MovementDTO(result);
    }

    @Transactional(readOnly = true)
    public MovementAccountDTO findByIdWithMovement(Long id) {
        Movement result = movementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new MovementAccountDTO(result);
    }

    @Transactional(readOnly = true)
    public List<MovementAccountDTO> findByIdWithMovements() {
        List<Movement> result = movementRepository.findByIdWithAccounts();
        return result.stream().map(MovementAccountDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public MovementAccountDTO insertNewMovements(MovementAccountDTO movementAccountDTO){
        Movement movementEntity = new Movement();
        Double valueDTO = movementAccountDTO.getMovementType() == MovementType.REVENUE ? movementAccountDTO.getValueMovement() : movementAccountDTO.getValueMovement() * -1;
        copyDtoToEntity(movementAccountDTO, movementEntity);
        Account result = accountRepository.findById(movementAccountDTO.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        if(result != null) {
            result.setBalance(result.getBalance() + valueDTO);
            accountRepository.save(result);
        }
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
