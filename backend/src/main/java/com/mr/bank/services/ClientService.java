package com.mr.bank.services;

import com.mr.bank.dto.ClientDTO;
import com.mr.bank.entities.Client;
import com.mr.bank.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client clientEntity = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ClientDTO(clientEntity);
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
        return new ClientDTO(clientEntity);
    }

    @Transactional(readOnly = false)
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client clientEntity = clientRepository.getReferenceById(id);
        copyDtoToEntity(clientDTO, clientEntity);
        return new ClientDTO(clientRepository.save(clientEntity));
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client clientEntity) {
        clientEntity.setName(clientDTO.getName());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setPhone(clientDTO.getPhone());
    }
}
