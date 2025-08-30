package com.projet1.toolsManagementSystem.controller;

import com.projet1.toolsManagementSystem.model.Tache;
import com.projet1.toolsManagementSystem.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organisations/{organisationId}/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping("/membres/{membreId}")
    public ResponseEntity<Tache> createTache(@PathVariable Long membreId, @RequestBody Tache tache) {
        return ResponseEntity.ok(tacheService.createTache(tache));
    }

    @GetMapping
    public ResponseEntity<List<Tache>> getTachesByOrganisation(@PathVariable Long organisationId) {
        return ResponseEntity.ok(tacheService.getTachesByOrganisation(organisationId));
    }

    @GetMapping("/membres/{membreId}")
    public ResponseEntity<List<Tache>> getTachesByMembre(@PathVariable Long membreId) {
        return ResponseEntity.ok(tacheService.getTachesByMembre(membreId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable Long id) {
        return tacheService.getTacheById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache tache) {
        return tacheService.getTacheById(id)
                .map(existingTache -> {
                    tache.setId(id);
                    return ResponseEntity.ok(tacheService.updateTache(tache));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        return tacheService.getTacheById(id)
                .map(tache -> {
                    tacheService.deleteTache(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 