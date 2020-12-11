package businesslogic;

import businesslogic.activity.*;
import java.util.*;
import database.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ugobarbato
 */
public class Planner extends User {

    private Map<Integer, MaintenanceActivity> scheduledActivity;
    private Repository rep;

    public Planner() throws ClassNotFoundException, SQLException {
        scheduledActivity = new HashMap<>();
        rep = Repository.getIstance();
    }

    public void assignActivity(String username, int activityID) {

    }

    public MaintenanceActivity createActivity(int id, String materials, int week, String site,
            MaintenanceType type, String description,
            int estimatedInterventionTime, boolean interruptible,
            String workspaceNotes, String procedure) throws SQLException {
        rep.insert("insert into activity(id,materials,week,site,maintenance_type,activity_type,description,estimated_time,interruptible,workspace_notes,maintenance_procedure)"
                + "values('" + id + "','" + materials + "','" + week + "','" + site + "','" + type.toString() + "','" + "Planned" + "','"
                + description + "','" + estimatedInterventionTime + "','" + interruptible + "','" + workspaceNotes + "','" + procedure + "');");
        MaintenanceActivity activity = ActivityFactory.getActivity(ActivityFactory.ActivityType.PLANNED);
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

    public void modifyActivity(int id, String workspaceNotes) throws SQLException {
        scheduledActivity.get(id).setWorkspaceNotes(workspaceNotes);
        rep.update("update activity set workspace_notes = '" + workspaceNotes + "' where id = '" + id + "'");
    }

    public void deleteActivity(int id) throws SQLException {
        rep.delete("delete from activity where id = '" + id + "'");
        scheduledActivity.remove(id);
    }

    private MaintenanceType getMaintenanceType(String maintenanceType) {
        if (maintenanceType.equals("Mechanical")) {
            return MaintenanceType.MECHANICAL;
        } else if (maintenanceType.equals("Electronic")) {
            return MaintenanceType.ELECTRONIC;
        } else if (maintenanceType.equals("Electrical")) {
            return MaintenanceType.ELECTRICAL;
        }
        return MaintenanceType.HYDRAULIC;
    }

    public ResultSet getMaterials(int id) throws SQLException {
        ResultSet res = rep.select("select * from activity where id='" + id + "'");
        return res;
    }

    public ResultSet getSites() throws SQLException {
        return rep.select("select * from site");
    }

    public ResultSet weekSelection(int week) throws SQLException {
        return rep.select("select * from activity where week='" + week + "'");
    }

    public ResultSet getMaterialTable() throws SQLException {
        return rep.select("select * from material");
    }

    public Map<Integer, MaintenanceActivity> getScheduledActivity() throws SQLException {
        ResultSet res = rep.select("select * from activity");

        while (res.next()) {
            MaintenanceActivity activity = ActivityFactory.getActivity(ActivityFactory.ActivityType.PLANNED);
            activity.setId(res.getInt("id"));
            activity.setMaterials(res.getArray("materials").toString());
            activity.setWeek(res.getInt("week"));
            activity.setSite(res.getString("site"));
            activity.setType(this.getMaintenanceType(res.getString("maintenance_type")));
            activity.setDescription(res.getString("description"));
            activity.setEstimatedInterventionTime(res.getInt("estimated_time"));
            activity.setInterruptible(res.getBoolean("interruptible"));
            activity.setWorkspaceNotes(res.getString("workspace_notes"));
            activity.setProcedure(res.getString("maintenance_procedure"));
            this.scheduledActivity.put(res.getInt("id"), activity);
        }
        return scheduledActivity;
    }

    public MaintenanceActivity getScheduledActivityFromId(int id) throws SQLException {
        ResultSet res = rep.select("select * from activity where id='" + id + "'");
        MaintenanceActivity activity = null;
        while (res.next()) {
            activity = ActivityFactory.getActivity(ActivityFactory.ActivityType.PLANNED);
            activity.setId(res.getInt("id"));
            activity.setMaterials(res.getArray("materials").toString());
            activity.setWeek(res.getInt("week"));
            activity.setSite(res.getString("site"));
            activity.setType(this.getMaintenanceType(res.getString("maintenance_type")));
            activity.setDescription(res.getString("description"));
            activity.setEstimatedInterventionTime(res.getInt("estimated_time"));
            activity.setInterruptible(res.getBoolean("interruptible"));
            activity.setWorkspaceNotes(res.getString("workspace_notes"));
            activity.setProcedure(res.getString("maintenance_procedure"));
        }
        return activity;
    }
    
    public List<Maintainer> getMaintainers() throws SQLException, ClassNotFoundException {
        List<Maintainer> maintainersList = new ArrayList();
        
        
        ResultSet res = rep.select("select * from maintainer");
        while(res.next()) {
            Maintainer m = new Maintainer();
            m.setUsername(res.getString("username"));
            m.setAvailability(m.getHoursAvailability(m.getUsername()));
            maintainersList.add(m);
        }
        return maintainersList;
    }
}
