/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    }
    
    @Test
    public void testCreateActivity() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
