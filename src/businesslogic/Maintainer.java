package businesslogic;

import java.util.List;

/**
 *
 * @author ugobarbato
 */
public class Maintainer extends User {

    private List<String> competences;
    private int activityID;
    private Availability availability;

    public List<String> getCompetences() {
        return competences;
    }

    public int getActivityID() {
        return activityID;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void addCompetence(String competence) {
        this.competences.add(competence);
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}
