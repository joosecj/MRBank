package com.mr.bank.controllers;

import com.mr.bank.dto.MovementAccountDTO;
import com.mr.bank.dto.MovementDTO;
import com.mr.bank.services.MovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movements")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @GetMapping(value = "/{id}/min")
    public ResponseEntity<MovementDTO> findByIdMin(@PathVariable Long id) {
        MovementDTO dto = movementService.findByIdMin(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovementAccountDTO> findByIdWithMovement(@PathVariable Long id) {
        MovementAccountDTO dto = movementService.findByIdWithMovement(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MovementAccountDTO>> findAccountWithMovements() {
        List<MovementAccountDTO> list = movementService.findByIdWithMovements();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MovementAccountDTO> insert(@RequestBody @Valid MovementAccountDTO dto) {
        dto = movementService.insertNewMovements(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
