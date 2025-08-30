package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

abstract class User {
    private String id;
    private String name;
    Organization organization;

    // Constructeur de la classe User
    public User(String id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Organization getOrganization() {
        return organization;
    }

    // Méthode abstraite pour afficher les outils disponible de l'organisation
    public abstract void displayAvailableTools();
}
