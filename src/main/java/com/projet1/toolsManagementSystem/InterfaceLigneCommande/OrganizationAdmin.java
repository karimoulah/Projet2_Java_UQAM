package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.util.List;

public class OrganizationAdmin extends User {
    public OrganizationAdmin(String id, String name, Organization organization) {
        super(id, name, organization);
    }

    // Ajout de la methode pour afficher tous les outils
    public void displayAllTools() {
        List<Tool> tools = organization.getAllTools();
        System.out.println("---Liste de tous les outils--- :");
        for (Tool tool : tools) {
            System.out.println(tool.getName() + " (ID: " + tool.getId() + ")");
        }
    }

    // Refinition de la methode pour afficher les outils disponibles
    @Override
    public void displayAvailableTools() {
        List<Tool> tools = organization.getAllTools();
        System.out.println("---Liste des outils disponibles--- :");
        for (Tool tool : tools) {
            if (!tool.isAvailable()) {
                System.out.println(tool.getName() + " (ID: " + tool.getId() + ")");
            }
        }
    }

    // Ajout de la methode pour afficher tous les utilisateurs
    public void displayAllUsers() {
        List<User> users = organization.getAllUsers();
        System.out.println("---Liste de tous les utilisateurs--- :");
        for (User user : users) {
            System.out.println("ID: " + user.getId() + "   Nom: " + user.getName());
        }
    }

    // Ajout de la methode pour afficher tous les employés
    public void displayAllEmployees() {
        List<User> employees = organization.getEmployees();
        System.out.println("---Liste des employés--- :");
        for (User employee : employees) {
            System.out.println("ID: " + employee.getId() + "   Nom: " + employee.getName());
        }
    }

    // Ajout de la methode pour afficher tous les bénévoles
    public void displayAllVolunteers() {
        List<User> volunteers = organization.getVolunteers();
        System.out.println("---Liste des bénévoles--- :");
        for (User volunteer : volunteers) {
            System.out.println("ID: " + volunteer.getId() + "   Nom: " + volunteer.getName());
        }
    }
}
