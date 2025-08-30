package com.projet1.toolsManagementSystem.controller;

import com.projet1.toolsManagementSystem.model.Organisation;
import com.projet1.toolsManagementSystem.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @PostMapping
    public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) {
        return ResponseEntity.ok(organisationService.createOrganisation(organisation));
    }

    @GetMapping
    public ResponseEntity<List<Organisation>> getAllOrganisations() {
        return ResponseEntity.ok(organisationService.getAllOrganisations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisation> getOrganisationById(@PathVariable Long id) {
        return organisationService.getOrganisationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organisation> updateOrganisation(@PathVariable Long id, @RequestBody Organisation organisation) {
        return organisationService.getOrganisationById(id)
                .map(existingOrg -> {
                    organisation.setId(id);
                    return ResponseEntity.ok(organisationService.updateOrganisation(organisation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        return organisationService.getOrganisationById(id)
                .map(organisation -> {
                    organisationService.deleteOrganisation(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 