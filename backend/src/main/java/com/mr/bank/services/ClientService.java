package com.mr.bank.services;

import com.mr.bank.dto.AccountDTO;
import com.mr.bank.dto.ClientDTO;
import com.mr.bank.entities.Account;
import com.mr.bank.entities.Client;
import com.mr.bank.repositories.AccountRepository;
import com.mr.bank.repositories.ClientRepository;
import com.mr.bank.services.exceptions.DataBaseException;
import com.mr.bank.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client clientEntity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(clientEntity);
    }

    @Transactional(readOnly = true)
    public List<AccountDTO> findClientsByAccount(Long id) {
        Client result = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        List<Account> list = result.getAccounts();
        return list.stream().map(x -> new AccountDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional(readOnly = false)
    public ClientDTO insertNewClient(ClientDTO clientDTO){
            Client clientEntity = new Client();
            copyDtoToEntity(clientDTO, clientEntity);
            clientEntity = clientRepository.save(clientEntity);
            Account accountEntity = new Account();
            accountEntity.setClient(clientEntity);
            accountEntity.setAgency(5555L);
            accountEntity.setNumberCc(new Date().getTime());
            accountEntity.setBalance(0.0D);
            accountRepository.save(accountEntity);
            return new ClientDTO(clientEntity);
    }

    @Transactional(readOnly = false)
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client clientEntity = clientRepository.getReferenceById(id);
            copyDtoToEntity(clientDTO, clientEntity);
            return new ClientDTO(clientRepository.save(clientEntity));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade refencial");
        }

    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client clientEntity) {
        clientEntity.setName(clientDTO.getName());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setPhone(clientDTO.getPhone());
    }
}
