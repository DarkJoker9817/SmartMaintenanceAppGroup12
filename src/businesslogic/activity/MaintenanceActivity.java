/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.activity;

import businesslogic.MaintenanceType;

/**
 *
 * @author gioca
 */
public abstract class MaintenanceActivity {

    private int id;
    private String materials;
    private int week;
    private String site;
    private MaintenanceType type;
    private String description;
    private int estimatedInterventionTime;
    private boolean interruptible;
    private String workspaceNotes;
    private String procedure;

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setType(MaintenanceType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedInterventionTime(int estimatedInterventionTime) {
        this.estimatedInterventionTime = estimatedInterventionTime;
    }

    public void setInterruptible(boolean interruptible) {
        this.interruptible = interruptible;
    }

    public void setWorkspaceNotes(String workspaceNotes) {
        this.workspaceNotes = workspaceNotes;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public int getId() {
        return id;
    }

    public String getMaterials() {
        return materials;
    }

    public int getWeek() {
        return week;
    }

    public String getSite() {
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

    public String getProcedure() {
        return procedure;
    }

}
