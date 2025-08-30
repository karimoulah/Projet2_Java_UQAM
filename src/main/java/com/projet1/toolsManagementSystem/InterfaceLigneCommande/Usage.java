package com.projet1.toolsManagementSystem.InterfaceLigneCommande;

import java.time.LocalDateTime;

public class Usage {
    private String userId;
    private String toolId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Usage(String userId, String toolId, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.toolId = toolId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String  getUserId() {
        return userId;
    }

    public String getToolId() {
        return toolId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
}



