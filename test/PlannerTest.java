/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import businesslogic.MaintenanceType;
import businesslogic.Planner;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ugobarbato
 */
public class PlannerTest {
    private Planner p;
    
    @Before
    public void setUp() {
        p = new Planner("prova", "prova");
        p.createActivity(1, null, 0, null, MaintenanceType.HYDRAULIC, "test", 0, true, "test", null);
    }
    
    @After
    public void tearDown() {
        p.deleteActivity(1);
    }
    
    @Test
    public void testCreateActivity() {
        assertEquals(p.getScheduledActivity().size(), 1);
    }
    
    @Test
    public void testDeleteActivity() {
        p.deleteActivity(1);
        assertEquals(p.getScheduledActivity().size(), 0);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
