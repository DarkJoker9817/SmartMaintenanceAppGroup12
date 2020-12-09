package businesslogic;

import businesslogic.activity.*;
import java.util.*;

/**
 *
 * @author ugobarbato
 */
public class Planner extends User {

    private Map<Integer, MaintenanceActivity> scheduledActivity;

    public Planner() {
        scheduledActivity = new HashMap<>();
    }

    public void assignActivity() {

    }

    public MaintenanceActivity createActivity(int id, List<String> materials, int week, Site site,
            MaintenanceType type, String description,
            int estimatedInterventionTime, boolean interruptible,
            String workspaceNotes, MaintenanceProcedure procedure) {

        MaintenanceActivity activity = ActivityFactory.make(ActivityFactory.Category.PLANNED, null);
        activity.setId(id);
        activity.setMaterials(materials);
        activity.setWeek(week);
        activity.setType(type);
        activity.setSite(site);
        activity.setDescription(description);
        activity.setEstimatedInterventionTime(estimatedInterventionTime);
        activity.setInterruptible(interruptible);
        activity.setWorkspaceNotes(workspaceNotes);
        activity.setProcedure(procedure);

        return scheduledActivity.putIfAbsent(id, activity);
    }

    public MaintenanceActivity modifyActivity(int id, List<String> materials, int week, Site site,
            MaintenanceType type, String description,
            int estimatedInterventionTime, boolean interruptible,
            String workspaceNotes, MaintenanceProcedure procedure) {

        MaintenanceActivity activity = PlannedActivityFactory.make(ActivityFactory.Category.PLANNED, null);
        activity.setId(id);
        activity.setMaterials(materials);
        activity.setWeek(week);
        activity.setType(type);
        activity.setSite(site);
        activity.setDescription(description);
        activity.setEstimatedInterventionTime(estimatedInterventionTime);
        activity.setInterruptible(interruptible);
        activity.setWorkspaceNotes(workspaceNotes);
        activity.setProcedure(procedure);

        return scheduledActivity.replace(id, activity);
    }

    public void deleteActivity(int id) {
        scheduledActivity.remove(id);
    }

    public MaintenanceActivity getActivity(int id) {
        return scheduledActivity.get(id);
    }

    public Map<Integer, MaintenanceActivity> getScheduledActivity() {
        return scheduledActivity;
    }
}
