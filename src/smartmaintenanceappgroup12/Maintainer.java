package smartmaintenanceappgroup12;

import java.util.List;

/**
 *
 * @author ugobarbato
 */
public class Maintainer extends User{
    
    private List<Competence> competences;
    private MaintenanceProcedure procedure;
    private int activityID;
    private Availability availability;
    
    public Maintainer(String username, String password) {
        super(username, password);
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public MaintenanceProcedure getProcedure() {
        return procedure;
    }

    public int getActivityID() {
        return activityID;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public void setProcedure(MaintenanceProcedure procedure) {
        this.procedure = procedure;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    
}
