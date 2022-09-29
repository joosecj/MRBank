package com.mr.bank.services;

import com.mr.bank.dto.AccountClientDTO;
import com.mr.bank.dto.AccountDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.entities.Account;
import com.mr.bank.entities.Movement;
import com.mr.bank.repositories.AccountRepository;
import com.mr.bank.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public AccountDTO findByIdMin(Long id) {
        Account result = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AccountDTO(result);
    }

    @Transactional(readOnly = true)
    public AccountClientDTO findAccountByIdWithClient(Long id) {
        Account result = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AccountClientDTO(result);
    }

    @Transactional(readOnly = true)
    public List<AccountClientDTO> findAccountsByWithClients() {
        List<Account> result = accountRepository.findByIdWithClients();
        return result.stream().map(x -> new AccountClientDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MovementDTO> findAccountByMovements(Long id) {
        Account result = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        List<Movement> list = result.getMovementList();
        return list.stream().map(x -> new MovementDTO(x)).toList();
    }

}
