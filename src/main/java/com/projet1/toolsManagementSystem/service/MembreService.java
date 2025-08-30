package com.projet1.toolsManagementSystem.service;

import com.projet1.toolsManagementSystem.model.Membre;
import com.projet1.toolsManagementSystem.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MembreService {
    
    @Autowired
    private MembreRepository membreRepository;

    public Membre createMembre(Membre membre) {
        return membreRepository.save(membre);
    }

    public List<Membre> getMembresByOrganisation(Long organisationId) {
        return membreRepository.findByOrganisationId(organisationId);
    }

    public Optional<Membre> getMembreById(Long id) {
        return membreRepository.findById(id);
    }

    public Membre updateMembre(Membre membre) {
        return membreRepository.save(membre);
    }

    public void deleteMembre(Long id) {
        membreRepository.deleteById(id);
    }
} 