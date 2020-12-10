/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PlannerTest {

    private Planner p;
    private Repository rep;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        p = new Planner();
        rep = Repository.getIstance();
        rep.delete("delete from activity");
        p.createActivity(1, "{}", 0, null, MaintenanceType.HYDRAULIC, "test", 0, true, "test", "");
    }

    /**
     *
     * Tests if an activity is created checking if the size of the map is equal
     * to 1.
     */
    @Test
    public void testCreateActivity() throws SQLException {
        assertEquals(p.getScheduledActivity().size(), 1);
    }

    @Test
    public void testModifyActivity() throws SQLException {
        p.modifyActivity(1, "prova");
        assertEquals(p.getScheduledActivity().size(), 1);
    }

    @Test
    public void testDeleteActivity() throws SQLException {
        p.deleteActivity(1);
        assertEquals(p.getScheduledActivity().size(), 0);
    }

    @Test
    public void testGetMaterialsNotNull() throws SQLException {
        assertNotNull(p.getMaterials(1));
    }

    @Test
    public void testGetSitesNotNull() throws SQLException {
        assertNotNull(p.getSites());
    }

    @Test
    public void testGetWeekSelectionNotNull() throws SQLException {
        assertNotNull(p.weekSelection(0));
    }

    @Test
    public void testGetMaterialTableNotNull() throws SQLException {
        assertNotNull(p.getMaterials(1));
    }

    @After
    public void tearDown() throws SQLException {
        rep.delete("delete from activity where id = '1'");
    }

}
