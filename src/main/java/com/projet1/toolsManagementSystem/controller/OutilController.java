package com.projet1.toolsManagementSystem.controller;

import com.projet1.toolsManagementSystem.model.Outil;
import com.projet1.toolsManagementSystem.service.OutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organisations/{organisationId}/outils")
public class OutilController {

    @Autowired
    private OutilService outilService;

    @PostMapping
    public ResponseEntity<Outil> createOutil(@PathVariable Long organisationId, @RequestBody Outil outil) {
        return ResponseEntity.ok(outilService.createOutil(outil));
    }

    @GetMapping
    public ResponseEntity<List<Outil>> getOutilsByOrganisation(@PathVariable Long organisationId) {
        return ResponseEntity.ok(outilService.getOutilsByOrganisation(organisationId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outil> getOutilById(@PathVariable Long id) {
        return outilService.getOutilById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outil> updateOutil(@PathVariable Long id, @RequestBody Outil outil) {
        return outilService.getOutilById(id)
                .map(existingOutil -> {
                    outil.setId(id);
                    return ResponseEntity.ok(outilService.updateOutil(outil));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutil(@PathVariable Long id) {
        return outilService.getOutilById(id)
                .map(outil -> {
                    outilService.deleteOutil(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 