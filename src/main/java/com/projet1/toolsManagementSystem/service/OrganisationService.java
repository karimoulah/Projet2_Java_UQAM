package com.projet1.toolsManagementSystem.service;

import com.projet1.toolsManagementSystem.model.Organisation;
import com.projet1.toolsManagementSystem.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {
    
    @Autowired
    private OrganisationRepository organisationRepository;

    public Organisation createOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    public Optional<Organisation> getOrganisationById(Long id) {
        return organisationRepository.findById(id);
    }

    public Organisation updateOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public void deleteOrganisation(Long id) {
        organisationRepository.deleteById(id);
    }
} 