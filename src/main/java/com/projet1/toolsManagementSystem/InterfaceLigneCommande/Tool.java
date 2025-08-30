package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tool {
    private String id;
    private String name;
    private boolean isOccupied;
    private List<Usage> usageHistory;

    public Tool(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOccupied = false;
        this.usageHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isOccupied;
    }

    public void occupy(String userId) {
        if (isOccupied)
            throw new IllegalStateException("Cette outil  est déja occupé");
        isOccupied = true;
        Usage usageLog = new Usage(userId, id, LocalDateTime.now(), null);
        usageHistory.add(usageLog);
    }

    // Liberer un outil
    public void release(String userId) {
        if (!isOccupied)
            throw new IllegalStateException("Cette outil n'est pas occupé");
        isOccupied = false;
        for (Usage usage : usageHistory) {
            if (usage.getUserId().equals(userId) && usage.getEndDate() == null) {
                usage.setEndDate(LocalDateTime.now());
                break;
            }
        }
    }
    
    public List<Usage> getUsageHistory() {
        usageHistory.forEach(usage -> {
            System.out.println("L'utilisateur " + usage.getUserId() + " a utilisé " + 
            usage.getToolId() + " entre " + usage.getStartDate() + " et " + usage.getEndDate());
        });
        return usageHistory;
    }

}
