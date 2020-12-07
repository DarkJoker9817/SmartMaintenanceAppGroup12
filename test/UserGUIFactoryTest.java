/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUIFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gioca
 */
public class UserGUIFactoryTest {

    @Test
    public void testNotNullJFrame() {
        assertNotNull(GUIFactory.getGUI("System Administrator"));
        assertNotNull(GUIFactory.getGUI("Planner"));
        assertNotNull(GUIFactory.getGUI("Maintainer"));

    }

    @Test
    public void testNullJFrame() {
        assertNull(GUIFactory.getGUI(""));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
