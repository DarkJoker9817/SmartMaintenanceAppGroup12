package businesslogic;

import database.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ugobarbato
 */
public class Maintainer extends User {

    private String[] competences;
    private Repository rep;
    private Integer[][] availability;

    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Maintainer() throws ClassNotFoundException, SQLException {
        rep = Repository.getIstance();
    }

    /**
     * 
     * @return a String array representing Maintainer's competences
     */
    public String[] getCompetences() {
        return competences;
    }

    /**
     * Set the competences of a maintainer
     * @param competences a String array representing Maintainer's competences
     */
    public void setCompetences(String[] competences) {
        this.competences = competences;
    }

    /**
     * Set the availability of a maintainer
     * @param availability an Integer 2D array representing Maintainer's availabilities
     */
    public void setAvailability(Integer[][] availability) {
        this.availability = availability;
    }
    
    /**
     * 
     * @param username a String representing the Maintainer's username
     * @return an Integer 2D array representing the Maintainer's availabilities
     *         during the hours of the day
     * @throws SQLException 
     */
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
    
    /**
     * 
     * @param username a String representing the Maintainer's username
     * @return an Integer array representing an availability percentage during
     *         the days of the week
     * @throws SQLException 
     */
    public Integer[] getDaysAvailability(String username) throws SQLException {
        Integer[][] matrix = new Integer[7][7];
        matrix = this.getHoursAvailability(username);
        Integer[] days = new Integer[7];

        for (int i = 0; i < 7; i++) {
            float counter = 0;
            for (int j = 0; j < 7; j++) {
                counter += matrix[i][j];
            }
            days[i] = (int) ((counter / 420) * 100);
        }
        return days;
    }
    
    
}   
