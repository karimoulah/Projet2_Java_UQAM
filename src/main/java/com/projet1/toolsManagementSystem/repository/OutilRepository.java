package com.projet1.toolsManagementSystem.repository;

import com.projet1.toolsManagementSystem.model.Outil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OutilRepository extends JpaRepository<Outil, Long> {
    List<Outil> findByOrganisationId(Long organisationId);
} 