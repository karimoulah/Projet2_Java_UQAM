package com.projet1.toolsManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "taches")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeTache type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EtatTache etat;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "membre_id", nullable = false)
    private Membre membre;

    @ManyToMany
    @JoinTable(
        name = "tache_outil",
        joinColumns = @JoinColumn(name = "tache_id"),
        inverseJoinColumns = @JoinColumn(name = "outil_id")
    )
    private List<Outil> outils;
} 