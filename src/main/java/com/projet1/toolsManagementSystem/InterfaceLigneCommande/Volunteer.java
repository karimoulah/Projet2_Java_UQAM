package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.util.List;

public class Volunteer extends User implements IToolUser {
    public Volunteer(String id, String name, Organization organization) {
        super(id, name, organization);
    }

    @Override
    public void displayAvailableTools() {
        List<Tool> tools = organization.getAllTools();
        tools.stream().filter(tool -> !tool.isAvailable())
        .forEach(tool -> System.out.println(tool.getName() + " (ID: " + tool.getId() + ")"));
    }

    @Override
    public void occupyTool(String toolId, String userId) {
        Tool tool = organization.getAllTools().stream()
        .filter(currentTool -> currentTool.getId().equals(toolId))
        .findFirst()
        .orElse(null);
        if (tool == null) {
            System.out.println("L'outil avec l'ID " + toolId + " n'existe pas.");
            return;
        }
        tool.occupy(userId);
    }

    @Override
    public void releaseTool(String toolId, String userId) {
        Tool tool = organization.getAllTools().stream()
        .filter(currentTool -> currentTool.getId().equals(toolId))
        .findFirst()
        .orElse(null);

        if (tool == null) {
            System.out.println("L'outil avec l'ID " + toolId + " n'existe pas.");
            return;
        }
        tool.release(userId);
    }
    
    

    
    
}
