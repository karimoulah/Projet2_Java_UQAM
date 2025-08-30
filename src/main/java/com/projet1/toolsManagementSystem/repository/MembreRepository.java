package com.projet1.toolsManagementSystem.repository;

import com.projet1.toolsManagementSystem.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {
    List<Membre> findByOrganisationId(Long organisationId);
} 