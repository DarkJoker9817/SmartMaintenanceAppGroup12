package businesslogic;

import java.util.List;
import database.Repository;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ugobarbato
 */
public class Maintainer extends User {

    private List<String> competences;
    private int activityID;
    private Availability availability;
    private Repository rep;
    
    public Maintainer() throws SQLException, ClassNotFoundException {
        this.rep = Repository.getIstance();
    }

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
    
    public Integer[][] getHoursAvailability(String username) throws SQLException {
        Integer[][] matrix = new Integer[7][7];
        
        ResultSet availabilities = rep.select("select availability from maintainer where username = '" + username + "'");
            while (availabilities.next()) {
                ResultSet res = availabilities.getArray("availability").getResultSet();
                int i=0;
                while (res.next()) {
                
                    ResultSet res2 = res.getArray(2).getResultSet();
                    for(int j=0; j<7 && res2.next(); j++) {
                        matrix[i][j] = res2.getInt(2);
                    }
                    i++;
                    
                }
                
            }
        return matrix;
    }
    
    public Integer[] getDaysAvailability(String username) throws SQLException {
        Integer[][] matrix = new Integer[7][7];
        matrix = this.getHoursAvailability(username);
        Integer[] days = new Integer[7];
        
        for(int i=0;i<7;i++) {
            int counter = 0;
            for(int j=0;j<7;j++) {
                counter += matrix[i][j];
            }
            days[i] = (counter/420)*100;
        }
        return days;
    }
}
