package com.projet1.toolsManagementSystem.repository;

import com.projet1.toolsManagementSystem.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByMembreOrganisationId(Long organisationId);
    List<Tache> findByMembreId(Long membreId);
} 