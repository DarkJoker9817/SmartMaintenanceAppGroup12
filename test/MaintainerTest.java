/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.Maintainer;
import businesslogic.MaintenanceType;
import businesslogic.Planner;
import database.Repository;
import java.sql.SQLException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ugobarbato
 */
public class MaintainerTest {

    private Maintainer m;
    private Repository rep;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        m = new Maintainer();
        rep = Repository.getIstance();
        rep.delete("delete from maintainer");
        rep.insert("insert into maintainer(username,availability,competencies) values('test1','{{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}','{}')");
    }

    @Test
    public void testCompetencesNull() throws SQLException {
        assertNull(m.getCompetences());
    }
    
    @Test
    public void testCompetencesNotNull() throws SQLException {
        String[] string = {"prova","prova2"};
        m.setCompetences(string);
        assertNotNull(m.getCompetences());
    }
    
    @Test
    public void testAvailabilityNotNull() throws SQLException {
        assertNotNull(m.getHoursAvailability("test1"));
    }
    
    @Test
    public void testGetDaysAvailabilityNotNull() throws SQLException {
        assertNotNull(m.getDaysAvailability("test1"));
    }
  
    @After
    public void tearDown() throws SQLException {
        rep.delete("delete from maintainer where username = 'test1'");
    }

}
