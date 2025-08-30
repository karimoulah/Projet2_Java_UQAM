package com.projet1.toolsManagementSystem.service;

import com.projet1.toolsManagementSystem.model.Tache;
import com.projet1.toolsManagementSystem.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TacheService {
    
    @Autowired
    private TacheRepository tacheRepository;

    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public List<Tache> getTachesByOrganisation(Long organisationId) {
        return tacheRepository.findByMembreOrganisationId(organisationId);
    }

    public List<Tache> getTachesByMembre(Long membreId) {
        return tacheRepository.findByMembreId(membreId);
    }

    public Optional<Tache> getTacheById(Long id) {
        return tacheRepository.findById(id);
    }

    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }
} 