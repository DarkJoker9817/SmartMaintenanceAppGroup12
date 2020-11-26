/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.List;

/**
 *
 * @author gioca
 */
public abstract class MaintenanceActivity {
    
    private int id;
    private List<String> materials;
    private int week;
    private Site site;
    private MaintenanceType type;
    private String description;
    private int estimatedInterventionTime;
    private boolean interruptible;
    private String workspaceNotes;
    private MaintenanceProcedure procedure;

    public int getId() {
        return id;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public int getWeek() {
        return week;
    }

    public Site getSite() {
        return site;
    }

    public MaintenanceType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedInterventionTime() {
        return estimatedInterventionTime;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public String getWorkspaceNotes() {
        return workspaceNotes;
    }

    public MaintenanceProcedure getProcedure() {
        return procedure;
    }
    
    
    
    
    
}
