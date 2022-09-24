package com.mr.bank.services;

import com.mr.bank.dto.AccountClientDTO;
import com.mr.bank.dto.AccountDTO;
import com.mr.bank.dto.ClientDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.entities.Account;
import com.mr.bank.entities.Client;
import com.mr.bank.entities.Movement;
import com.mr.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public AccountDTO findByIdMin(Long id) {
        Optional<Account> result = accountRepository.findById(id);
        return new AccountDTO(result.get());
    }

    @Transactional(readOnly = true)
    public AccountClientDTO findByIdWithClient(Long id) {
        Optional<Account> result = accountRepository.findById(id);
        return new AccountClientDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<AccountClientDTO> findByIdWithClients() {
        List<Account> result = accountRepository.findByIdWithClients();
        return result.stream().map(x -> new AccountClientDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MovementDTO> findAccountsByMovement(Long id) {
        Optional<Account> result = accountRepository.findById(id);
        List<Movement> list = result.get().getMovementList();
        return list.stream().map(x -> new MovementDTO(x)).toList();
    }

}
