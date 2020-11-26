/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.activity;

import businesslogic.MaintenanceProcedure;
import businesslogic.MaintenanceType;
import businesslogic.Site;
import java.util.List;

/**
 *
 * @author gioca
 */
public class PlannedActivity extends MaintenanceActivity {

    public PlannedActivity(int id, List<String> materials, int week, Site site, MaintenanceType type, String description, int estimatedInterventionTime, boolean interruptible, String workspaceNotes, MaintenanceProcedure procedure) {
        super(id, materials, week, site, type, description, estimatedInterventionTime, interruptible, workspaceNotes, procedure);
    }
    
    

}
