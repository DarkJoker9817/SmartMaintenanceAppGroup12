package businesslogic;

import java.util.List;
import database.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ugobarbato
 */
public class Maintainer extends User {

    private List<String> competences;
    private Repository rep;
    private Integer[][] availability;

    public Maintainer() throws ClassNotFoundException, SQLException {
        rep = Repository.getIstance();
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public void setAvailability(Integer[][] availability) {
        this.availability = availability;
    }
    
    public void addCompetence(String competence) {
        this.competences.add(competence);
    }
    
    public Integer[][] getHoursAvailability(String username) throws SQLException {
        Integer[][] matrix = new Integer[7][7];

        ResultSet availabilities = rep.select("select availability from maintainer where username = '" + username + "'");
        while (availabilities.next()) {
            ResultSet res = availabilities.getArray("availability").getResultSet();
            int i = 0;
            while (res.next()) {

                ResultSet res2 = res.getArray(2).getResultSet();
                for (int j = 0; j < 7 && res2.next(); j++) {
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

        for (int i = 0; i < 7; i++) {
            int counter = 0;
            for (int j = 0; j < 7; j++) {
                counter += matrix[i][j];
            }
            days[i] = (counter / 420) * 100;
        }
        return days;
    }
    
    
}   
