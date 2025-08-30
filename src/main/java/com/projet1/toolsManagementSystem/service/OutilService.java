package com.projet1.toolsManagementSystem.service;

import com.projet1.toolsManagementSystem.model.Outil;
import com.projet1.toolsManagementSystem.repository.OutilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OutilService {
    
    @Autowired
    private OutilRepository outilRepository;

    public Outil createOutil(Outil outil) {
        return outilRepository.save(outil);
    }

    public List<Outil> getOutilsByOrganisation(Long organisationId) {
        return outilRepository.findByOrganisationId(organisationId);
    }

    public Optional<Outil> getOutilById(Long id) {
        return outilRepository.findById(id);
    }

    public Outil updateOutil(Outil outil) {
        return outilRepository.save(outil);
    }

    public void deleteOutil(Long id) {
        outilRepository.deleteById(id);
    }
} 