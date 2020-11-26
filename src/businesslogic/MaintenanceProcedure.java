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
public class MaintenanceProcedure {

    private String maintenanceProcedure;
    private List<String> competencies;

    public MaintenanceProcedure(String maintenanceProcedure) {
        this.maintenanceProcedure = maintenanceProcedure;
    }

    public String getMaintenanceProcedure() {
        return maintenanceProcedure;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public void addCompetence(String competence) {
        this.competencies.add(competence);
    }

}
