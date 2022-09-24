package com.mr.bank.controllers;

import com.mr.bank.dto.AccountClientDTO;
import com.mr.bank.dto.AccountDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/{id}/min")
    public ResponseEntity<AccountDTO> findByIdMin(@PathVariable Long id) {
        AccountDTO dto = accountService.findByIdMin(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountClientDTO> findByIdWithClient(@PathVariable Long id) {
        AccountClientDTO dto = accountService.findByIdWithClient(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AccountClientDTO>> findEmployeesWithClients() {
        List<AccountClientDTO> list = accountService.findByIdWithClients();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}/movements")
    public ResponseEntity<List<MovementDTO>> findEmployeesByDepartment(@PathVariable Long id) {
        List<MovementDTO> list = accountService.findAccountsByMovement(id);
        return ResponseEntity.ok(list);
    }
}
