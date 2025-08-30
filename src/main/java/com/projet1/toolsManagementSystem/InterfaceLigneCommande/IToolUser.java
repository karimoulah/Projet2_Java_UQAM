package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

public interface IToolUser {
    void occupyTool(String toolId, String userId);
    void releaseTool(String toolId, String userId);
}
