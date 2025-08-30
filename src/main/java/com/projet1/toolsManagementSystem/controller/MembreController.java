package com.projet1.toolsManagementSystem.controller;

import com.projet1.toolsManagementSystem.model.Membre;
import com.projet1.toolsManagementSystem.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organisations/{organisationId}/membres")
public class MembreController {

    @Autowired
    private MembreService membreService;

    @PostMapping
    public ResponseEntity<Membre> createMembre(@PathVariable Long organisationId, @RequestBody Membre membre) {
        return ResponseEntity.ok(membreService.createMembre(membre));
    }

    @GetMapping
    public ResponseEntity<List<Membre>> getMembresByOrganisation(@PathVariable Long organisationId) {
        return ResponseEntity.ok(membreService.getMembresByOrganisation(organisationId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable Long id) {
        return membreService.getMembreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membre> updateMembre(@PathVariable Long id, @RequestBody Membre membre) {
        return membreService.getMembreById(id)
                .map(existingMembre -> {
                    membre.setId(id);
                    return ResponseEntity.ok(membreService.updateMembre(membre));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembre(@PathVariable Long id) {
        return membreService.getMembreById(id)
                .map(membre -> {
                    membreService.deleteMembre(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 