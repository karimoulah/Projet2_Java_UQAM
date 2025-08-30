package com.projet1.toolsManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "nombre_membres")
    private int nombreMembres;

    @Column(name = "score_total")
    private int scoreTotal;

    @Column(name = "nombre_taches_effectuees")
    private int nombreTachesEffectuees;

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL)
    private List<Membre> membres;

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL)
    private List<Outil> outils;
} 