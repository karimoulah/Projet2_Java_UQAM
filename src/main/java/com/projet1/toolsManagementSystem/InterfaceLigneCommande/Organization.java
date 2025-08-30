package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.util.List;
import java.util.ArrayList;

//Contructeur de l'organisation
public class Organization {
    private String name;
    private List<Tool> tools;
    private List<User> users;
    private OrganizationAdmin admin;

    public Organization(String name) {
        this.name = name;
        this.tools = new ArrayList<Tool>();
        this.users = new ArrayList<User>();
    }

    // Méthode pour ajout et suppression d'outils et d'utilisateurs
    public String getName() {
        return name;
    }

    public void addTool(Tool tool) {
        tools.add(tool);
    }

    public void removeTool(Tool tool) {
        tools.remove(tool);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public OrganizationAdmin getAdmin() {
        return admin;
    }

    // Méthode pour obtenir la liste des outils et des utilisateurs (employés et
    // bénévoles) de l'organisation
    public List<Tool> getAllTools() {
        return new ArrayList<>(tools);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public List<User> getEmployees() {
        return users.stream().filter(user -> user instanceof Employee).toList();
    }

    public List<User> getVolunteers() {
        return users.stream().filter(user -> user instanceof Volunteer).toList();
    }

    public Tool getToolById(String toolId) {
        return tools.stream().filter(tool -> tool.getId().equals(toolId)).findFirst().orElse(null);
    }
}
