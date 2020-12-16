package businesslogic;

import businesslogic.activity.*;
import java.util.*;
import database.Repository;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ugobarbato
 */
public class Planner extends User {
    
    /**
     * scheuledActivity: A data structure representing the activities scheduled from a planner
     * rep: A Repository object representing the database
     */
    private Map<Integer, MaintenanceActivity> scheduledActivity;
    private Repository rep;

    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Planner() throws ClassNotFoundException, SQLException {
        scheduledActivity = new HashMap<>();
        rep = Repository.getIstance();
    }

    /**
     * Assign the activity to the maintainer.
     * First is performed an insert in the assigned_activity table in repository,
     * then update activity setting it as assigned and finally updates maintainer's availability's matrix.
     * 
     * @param username a String representing the username of the Maintainer to whom 
     *                 to assign the activity
     * @param activityID an Integer representing the ID of the activity to assign
     * @param day a String representing the day of the weeek
     * @param hour an Integer representing the hour of the day
     * @param assignedMinutes an integer representing the estimated time of the activity
     * @param availableMinutes an integer representing the available time of the Maintainer
     * @param column an intenger representing the column index in the availability's matrix
     * @throws SQLException 
     */
    public void assignActivity(String username, int activityID, String day, int hour, int assignedMinutes, int availableMinutes, int column) throws SQLException {
        rep.insert("insert into assigned_activity(maintainer_username,assigned_activity_id ,assigned_activity_day ,assigned_activity_hour) "
                + "values('" + username + "','" + activityID + "','" + day + "','" + hour + "')");
        rep.update("update activity set assigned = true where id = " + activityID + "");
        int row = this.getWeekDayNumber(day);
        rep.update("update maintainer set availability[" + (row + 1) + "][" + (column + 1) + "]=" + (availableMinutes-assignedMinutes) + "where username ='" + username + "'");
    }

    /**
     * Create a new maintenance activity.
     * First the new activity is inserted in the database, then it is instatiated a new activity.
     * @param id an Integer representing the ID of the activity to create
     * @param materials a String representing a list of materials necessary to the activity
     * @param week an Integer representing the week in which to perform the activity
     * @param site a String representing the site where to perform the activity
     * @param type a MaintenanceType Object representing the type of the activity
     * @param description a String representing the informations about the activity
     * @param estimatedInterventionTime an Integer representing the estimated time to perform the activity
     * @param interruptible a boolean representing if an activity is interruptible
     * @param workspaceNotes a String representing additional notes on the workplace
     * @param procedure a String representing the name of the file in which is contained the steps of the procedure
     * @return a MaintenanceActivity object representing the created activity
     * @throws SQLException 
     */
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
        activity.setAssigned(false);

        return scheduledActivity.putIfAbsent(id, activity);
    }

    /**
     * Modify workspace note of the activity.
     * @param id an integer representing the ID of the activity to update
     * @param workspaceNotes a String representing the modified workspace notes
     * @throws SQLException 
     */
    public void modifyActivity(int id, String workspaceNotes) throws SQLException {
        scheduledActivity.get(id).setWorkspaceNotes(workspaceNotes);
        rep.update("update activity set workspace_notes = '" + workspaceNotes + "' where id = '" + id + "'");
    }

    /**
     * Delete an activity. First delete it from the database, then delete it from
     *                     the data structure of the scheduled activities
     * @param id an Integer representing the ID of the activity to delete
     * @throws SQLException 
     */
    public void deleteActivity(int id) throws SQLException {
        rep.delete("delete from activity where id = '" + id + "'");
        scheduledActivity.remove(id);
    }

    /**
     * 
     * @param maintenanceType a String representing the name of the type of activity
     * @return a MaintenanceType Object representing the type of the activity
     */
    private MaintenanceType getMaintenanceType(String maintenanceType) {
        if (maintenanceType.equals("MECHANICAL")) {
            return MaintenanceType.MECHANICAL;
        } else if (maintenanceType.equals("ELECTRONIC")) {
            return MaintenanceType.ELECTRONIC;
        } else if (maintenanceType.equals("ELECTRICAL")) {
            return MaintenanceType.ELECTRICAL;
        }
        return MaintenanceType.HYDRAULIC;
    }

    /**
     * 
     * @param id an Integer representing the ID of the activity
     * @return an Array Object in which are contained the materials necessary for the activity
     * @throws SQLException 
     */
    public Array getMaterials(int id) throws SQLException {
        ResultSet res = rep.select("select * from activity where id='" + id + "'");
        Array materials = null;
        while (res.next()) {
            materials = res.getArray("materials");
        }
        return materials;
    }

    /**
     * 
     * @return a ResultSet Object containing the sites
     * @throws SQLException 
     */
    public ResultSet getSites() throws SQLException {
        return rep.select("select * from site");
    }

    /**
     * Select from the database all the activities to be performed in the specified week.
     * @param week an Integer representing the week
     * @return a ResultSet Object containing the activities
     * @throws SQLException 
     */
    public ResultSet weekSelection(int week) throws SQLException {
        return rep.select("select * from activity where week='" + week + "' and assigned = false");
    }

    /**
     * Select from the database all the materials.
     * @return a ResultSet Object containing the materials
     * @throws SQLException 
     */
    public ResultSet getMaterialTable() throws SQLException {
        return rep.select("select * from material");
    }

    /**
     * Get all the activities scheduled from a planner.
     * First select the activities from the database, then instantiate them and
     * put them in the data structure.
     * @return a Map object representing the activities scheduled from a planner
     * @throws SQLException 
     */
    public Map<Integer, MaintenanceActivity> getScheduledActivity() throws SQLException {
        ResultSet res = rep.select("select * from activity");

        while (res.next()) {
            MaintenanceActivity activity = ActivityFactory.getActivity(ActivityFactory.ActivityType.PLANNED);
            activity.setId(res.getInt("id"));
            activity.setMaterials(res.getArray("materials") == null ? "{}" : res.getArray("materials").toString());
            activity.setWeek(res.getInt("week"));
            activity.setSite(res.getString("site"));
            activity.setType(this.getMaintenanceType(res.getString("maintenance_type")));
            activity.setDescription(res.getString("description"));
            activity.setEstimatedInterventionTime(res.getInt("estimated_time"));
            activity.setInterruptible(res.getBoolean("interruptible"));
            activity.setWorkspaceNotes(res.getString("workspace_notes"));
            activity.setProcedure(res.getString("maintenance_procedure"));
            activity.setAssigned(res.getBoolean("assigned"));
            this.scheduledActivity.put(res.getInt("id"), activity);
        }
        return scheduledActivity;
    }

    /**
     * Get a specific activity.
     * First select the activity with the specific ID from the database, then
     * instantiate it.
     * @param id an Integer representing the ID of an activity
     * @return a MaintenanceActivity Object representing the specific activity
     * @throws SQLException 
     */
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
            activity.setAssigned(res.getBoolean("assigned"));
            activity.setCompetences(res.getArray("competencies").toString().replaceAll("\\{", "").replaceAll("\\}","").split(","));
        }
        return activity;
    }

    /**
     * Get a list of Maintainers.
     * First select all the maintainers from the database, then instantiate them
     * and add them to the list.
     * @return a List of Maintainer Object 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public List<Maintainer> getMaintainers() throws SQLException, ClassNotFoundException {
        List<Maintainer> maintainersList = new ArrayList();

        ResultSet res = rep.select("select * from maintainer");
        while (res.next()) {
            Maintainer m = new Maintainer();
            m.setUsername(res.getString("username"));
            m.setAvailability(m.getHoursAvailability(m.getUsername()));
            m.setCompetences(res.getArray("competencies").toString().replaceAll("\\{", "").replaceAll("\\}","").split(","));
            maintainersList.add(m);
        }
        return maintainersList;
    }
    
    /**
     * Get the number of the corresponding day name.
     * @param day a String representing the name of the day
     * @return an Integer representing the number of the day in the week
     */
    public int getWeekDayNumber(String day) {
        if ("Monday".equals(day)) {
            return 0;
        } else if ("Tuesday".equals(day)) {
            return 1;
        } else if ("Wednesday".equals(day)) {
            return 2;
        } else if ("Thursday".equals(day)) {
            return 3;
        } else if ("Friday".equals(day)) {
            return 4;
        } else if ("Saturday".equals(day)) {
            return 5;
        } else {

            return 6;
        }
    }    
}
